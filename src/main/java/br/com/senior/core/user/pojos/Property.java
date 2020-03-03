package br.com.senior.core.user.pojos;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


/**
 * Representa uma propriedade
 */
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Property {
    
    /**
     * Nome da propriedade
     */
    public String name;
    /**
     * Valor da propriedade
     */
    public String value;

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
