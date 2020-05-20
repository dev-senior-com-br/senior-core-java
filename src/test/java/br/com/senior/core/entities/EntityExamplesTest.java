package br.com.senior.core.entities;

import br.com.senior.core.utils.EntityPage;
import br.com.senior.core.utils.Environment;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class EntityExamplesTest {

    public static final String ENTITY_NAME = "entityName";
    private EntitiesUtils<EntityObject> entityUtils;

    @Before
    public void before() {
        entityUtils = new EntitiesUtils<>(Environment.HOMOLOG, "domain", "service", "token", EntityObject.class);
    }

    @Test
    public void testGetEntity() {
        EntityPage<EntityObject> featureToggle = entityUtils.executeGet(ENTITY_NAME, null);
        assertNotNull(featureToggle);
    }

    @Test
    public void testGetByIdEntity() {
        EntityObject byIdResult = entityUtils.executeGetById(ENTITY_NAME, "123");
        assertNotNull(byIdResult);
    }

    @Test
    public void testPostEntity() {
        EntityObject payload = new EntityObject(123);
        EntityObject postResult = entityUtils.executePost(ENTITY_NAME, payload);
        assertNotNull(postResult);
    }

    @Test
    public void testPutEntity() {
        EntityObject payload = new EntityObject(123);
        EntityObject putResult = entityUtils.executePost(ENTITY_NAME, payload);
        assertNotNull(putResult);
    }

    @Test
    public void testDeleteEntity() {
        entityUtils.executeDelete(ENTITY_NAME, "123");
    }

    @Test
    public void testFilterEntity() {
        EntityPage<EntityObject> getByIdResult = entityUtils.executeGet(ENTITY_NAME, new FilterBuilder().field("id").equals("123").build());
        assertNotNull(getByIdResult);
    }

    @Data
    @AllArgsConstructor
    private static class EntityObject {
        long id;
    }
}
