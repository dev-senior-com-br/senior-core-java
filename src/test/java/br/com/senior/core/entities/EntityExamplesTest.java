package br.com.senior.core.entities;

import br.com.senior.core.utils.EntityPage;
import br.com.senior.core.utils.Environment;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EntityExamplesTest {

    public static final String ENTITY_NAME = "entityName";
    private EntityObject payload = new EntityObject(123);

    @Mock
    EntitiesUtils<EntityObject> entityUtils;

    @Before
    public void before() {
        EntityObject returnPayload = new EntityObject(123);
        when(entityUtils.executeGet(ENTITY_NAME, null)).thenReturn(new EntityPage<>(1, 1, new EntityObject[]{returnPayload}, EntityObject.class));
        when(entityUtils.executeGet(ENTITY_NAME, "?filter=id eq 123")).thenReturn(new EntityPage<>(1, 1, new EntityObject[]{returnPayload}, EntityObject.class));
        when(entityUtils.executeGetById(ENTITY_NAME, "123")).thenReturn(returnPayload);
        when(entityUtils.executePost(ENTITY_NAME, payload)).thenReturn(returnPayload);
        when(entityUtils.executePut(ENTITY_NAME, payload)).thenReturn(returnPayload);
        doNothing().when(entityUtils).executeDelete(ENTITY_NAME, "123");
        System.out.println();
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
