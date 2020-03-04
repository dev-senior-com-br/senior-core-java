package br.com.senior.core.user.pojos;

import java.util.List;

public class PropertyStringSerializer {
    
	public static final PropertyStringSerializer INSTANCE = new PropertyStringSerializer();
    
    public void serialize(Property property, StringBuilder sb, List<Object> appended) {
		sb.append(property.getClass().getSimpleName()).append(" [");
		if (appended.contains(property)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(property);
		serializeName(property, sb);
		sb.append(", ");
		serializeValue(property, sb);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeName(Property property, StringBuilder sb) {
		sb.append("name=").append(property.name == null ? "null" : property.name);
	}
	
	protected void serializeValue(Property property, StringBuilder sb) {
		sb.append("value=").append(property.value == null ? "null" : property.value);
	}
}
