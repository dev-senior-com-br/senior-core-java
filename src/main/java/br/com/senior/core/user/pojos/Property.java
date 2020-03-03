package br.com.senior.core.user.pojos;

import java.util.ArrayList;
import java.util.List;

import lombok.EqualsAndHashCode;


/**
 * Representa uma propriedade
 */
@EqualsAndHashCode
public class Property {
    
    /**
     * Nome da propriedade
     */
    public String name;
    /**
     * Valor da propriedade
     */
    public String value;
    
    public Property() {
    }
    
    /** 
     * This constructor allows initialization of all fields, required and optional.
     */
    public Property(String name, String value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
    	StringBuilder sb = new StringBuilder();
    	toString(sb, new ArrayList<>());
    	return sb.toString();
    }
    
    public void toString(StringBuilder sb, List<Object> appended) {
    	PropertyStringSerializer.INSTANCE.serialize(this, sb, appended);
    }
    
}
