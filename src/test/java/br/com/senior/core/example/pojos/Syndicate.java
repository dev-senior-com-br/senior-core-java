package br.com.senior.core.example.pojos;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Data
public class Syndicate {
    String id;
    Long code;
    String name;
    Long vacationMonths;
}
