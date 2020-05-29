package br.com.senior.core.base;

import com.google.gson.*;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class SeniorGsonBuilder {


    private final static String DATE = "yyyy-MM-dd";
    private final static String DATE_TIME = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    private final static String[] DATE_FORMATS = new String[]{DATE, DATE_TIME};

    public static Gson newGsonBuilder() {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Date.class, new SeniorGsonBuilder.DateTimeAdapter());
        builder.registerTypeAdapter(LocalDate.class, new SeniorGsonBuilder.DateAdapter());
        builder.registerTypeAdapter(LocalTime.class, new SeniorGsonBuilder.TimeAdapter());
        builder.registerTypeAdapter(byte[].class, new SeniorGsonBuilder.BlobAdapter());
        builder.registerTypeAdapter(Instant.class, new SeniorGsonBuilder.InstantAdapter());
        builder.registerTypeAdapterFactory(new SeniorGsonBuilder.SafeEnumAdapterFactory());
        builder.registerTypeAdapter(Boolean.class, new SeniorGsonBuilder.BooleanAdapter());
        builder.registerTypeAdapter(Long.class, new SeniorGsonBuilder.LongAdapter());
        builder.registerTypeAdapter(Double.class, new SeniorGsonBuilder.DoubleAdapter());
        return builder.create();
    }

    private static class DateTimeAdapter implements JsonSerializer<Date>, JsonDeserializer<Date> {
        private DateTimeAdapter() {
        }

        public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
            return src == null ? null : new JsonPrimitive(DateTimeFormatter.ISO_DATE_TIME.format(OffsetDateTime.ofInstant(src.toInstant(), ZoneOffset.UTC)));
        }

        public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
            if (json != null && !(json instanceof JsonNull)) {
                Date date = doFormat(json.getAsString());
                if (date == null) {
                    throw new JsonParseException("Unable to parse date: " + json.getAsString());
                }
                return date;
            } else {
                return null;
            }
        }
    }

    private static class InstantAdapter implements JsonSerializer<Instant>, JsonDeserializer<Instant> {
        private InstantAdapter() {
        }

        public JsonElement serialize(Instant src, Type typeOfSrc, JsonSerializationContext context) {
            return src == null ? null : new JsonPrimitive(DateTimeFormatter.ISO_DATE_TIME.format(OffsetDateTime.ofInstant(src, ZoneOffset.UTC)));
        }

        public Instant deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
            if (json != null && !(json instanceof JsonNull)) {
                try {
                    return OffsetDateTime.parse(json.getAsString(), DateTimeFormatter.ISO_DATE_TIME).toInstant();
                } catch (DateTimeParseException var5) {
                    throw new JsonParseException(var5);
                }
            } else {
                return null;
            }
        }
    }

    private static final class SafeEnumTypeAdapter<T extends Enum<T>> extends TypeAdapter<T> {
        private final Map<String, T> nameToConstant = new HashMap<>();
        private final Map<T, String> constantToName = new HashMap<>();

        public SafeEnumTypeAdapter(Class<T> classOfT) {
            try {
                T[] var2 = classOfT.getEnumConstants();

                for (T anEnum : var2) {
                    String name = anEnum.name();
                    SerializedName annotation = classOfT.getField(name).getAnnotation(SerializedName.class);
                    if (annotation != null) {
                        name = annotation.value();
                    }

                    this.nameToConstant.put(name, anEnum);
                    this.constantToName.put(anEnum, name);
                }

            } catch (NoSuchFieldException var8) {
                throw new AssertionError(var8);
            }
        }

        public T read(JsonReader in) throws IOException {
            if (in.peek() == JsonToken.NULL) {
                in.nextNull();
                return null;
            } else {
                String name = in.nextString();
                T value = this.nameToConstant.get(name);
                if (value == null) {
                    Set<String> possibleNames = new TreeSet<>(this.nameToConstant.keySet());
                    throw new IncompatibleValueException("Value " + name + " is invalid. Possible values: " + String.join(", ", possibleNames));
                } else {
                    return value;
                }
            }
        }

        public void write(JsonWriter out, T value) throws IOException {
            out.value(value == null ? null : this.constantToName.get(value));
        }
    }

    protected static final class DoubleAdapter implements JsonDeserializer<Double> {
        protected DoubleAdapter() {
        }

        public Double deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
            if (json != null && !(json instanceof JsonNull)) {
                String value = json.getAsString();

                try {
                    Double parseValue = Double.parseDouble(value);
                    if (parseValue.isInfinite()) {
                        throw new JsonParseException(String.format("Invalid Object: %s", json));
                    } else {
                        return parseValue;
                    }
                } catch (NumberFormatException var6) {
                    throw new JsonParseException(var6);
                }
            } else {
                throw new JsonParseException(String.format("Invalid Object: %s", json));
            }
        }
    }

    protected static final class LongAdapter implements JsonDeserializer<Long> {
        protected LongAdapter() {
        }

        public Long deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
            if (json != null && !(json instanceof JsonNull)) {
                String value = json.getAsString();

                try {
                    return Long.parseLong(value);
                } catch (NumberFormatException var6) {
                    throw new JsonParseException(var6);
                }
            } else {
                throw new JsonParseException(String.format("Invalid Object: %s", json));
            }
        }
    }

    protected static final class BooleanAdapter implements JsonDeserializer<Boolean> {
        protected BooleanAdapter() {
        }

        public Boolean deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
            if (json != null && !(json instanceof JsonNull)) {
                String value = json.getAsString();
                if (!value.equalsIgnoreCase("true") && !value.equalsIgnoreCase("false")) {
                    throw new JsonParseException(String.format("Invalid Object: %s", json));
                } else {
                    return Boolean.parseBoolean(value);
                }
            } else {
                throw new JsonParseException(String.format("Invalid Object: %s", json));
            }
        }
    }

    private static class SafeEnumAdapterFactory implements TypeAdapterFactory {
        private SafeEnumAdapterFactory() {
        }

        public <T> SafeEnumTypeAdapter create(Gson gson, TypeToken<T> typeToken) {
            Class<? super T> rawType = typeToken.getRawType();
            if (Enum.class.isAssignableFrom(rawType) && rawType != Enum.class) {
                if (!rawType.isEnum()) {
                    rawType = rawType.getSuperclass();
                }

                return new SeniorGsonBuilder.SafeEnumTypeAdapter(rawType);
            } else {
                return null;
            }
        }
    }

    private static class BlobAdapter implements JsonSerializer<byte[]>, JsonDeserializer<byte[]> {
        private BlobAdapter() {
        }

        public JsonElement serialize(byte[] src, Type typeOfSrc, JsonSerializationContext context) {
            return src == null ? null : new JsonPrimitive(Base64.getEncoder().encodeToString(src));
        }

        public byte[] deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
            if (json != null && !(json instanceof JsonNull)) {
                try {
                    return Base64.getDecoder().decode(json.getAsString());
                } catch (DateTimeParseException var5) {
                    throw new JsonParseException(var5);
                }
            } else {
                return null;
            }
        }
    }

    private static class TimeAdapter implements JsonSerializer<LocalTime>, JsonDeserializer<LocalTime> {
        private TimeAdapter() {
        }

        public JsonElement serialize(LocalTime src, Type typeOfSrc, JsonSerializationContext context) {
            return src == null ? null : new JsonPrimitive(DateTimeFormatter.ISO_LOCAL_TIME.format(src));
        }

        public LocalTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
            if (json != null && !(json instanceof JsonNull)) {
                try {
                    return LocalTime.parse(json.getAsString(), DateTimeFormatter.ISO_LOCAL_TIME);
                } catch (DateTimeParseException var5) {
                    throw new JsonParseException(var5);
                }
            } else {
                return null;
            }
        }
    }

    private static class DateAdapter implements JsonSerializer<LocalDate>, JsonDeserializer<LocalDate> {
        private DateAdapter() {
        }

        public JsonElement serialize(LocalDate src, Type typeOfSrc, JsonSerializationContext context) {
            return src == null ? null : new JsonPrimitive(DateTimeFormatter.ISO_LOCAL_DATE.format(src));
        }

        public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
            if (json != null && !(json instanceof JsonNull)) {
                try {
                    return LocalDate.parse(json.getAsString(), DateTimeFormatter.ISO_LOCAL_DATE);
                } catch (DateTimeParseException var5) {
                    throw new JsonParseException(var5);
                }
            } else {
                return null;
            }
        }
    }

    private static Date doFormat(String strDate) {
        for (String format : DATE_FORMATS) {
            try {
                return new SimpleDateFormat(format).parse(strDate);
            } catch (ParseException e) {
                //doNothing
            }
        }
        return null;
    }

}
