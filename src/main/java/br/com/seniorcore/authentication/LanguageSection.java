/*
 * hcm-recruitment
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: ${version}
 * Contact: seniorx-dev@senior.com.br
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.swagger.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.client.model.LanguageProficiencyDto;
import java.io.IOException;
import org.threeten.bp.OffsetDateTime;

/**
 * LanguageSection
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-07-15T19:10:27.342Z")
public class LanguageSection {
  @SerializedName("createdAt")
  private OffsetDateTime createdAt = null;

  @SerializedName("resumeId")
  private String resumeId = null;

  @SerializedName("language")
  private String language = null;

  @SerializedName("id")
  private String id = null;

  @SerializedName("proficiency")
  private LanguageProficiencyDto proficiency = null;

  @SerializedName("updatedAt")
  private OffsetDateTime updatedAt = null;

  public LanguageSection createdAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

   /**
   * Data de criação.
   * @return createdAt
  **/
  @ApiModelProperty(value = "Data de criação.")
  public OffsetDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public LanguageSection resumeId(String resumeId) {
    this.resumeId = resumeId;
    return this;
  }

   /**
   * Identificador do currículo à qual o idioma está associado.
   * @return resumeId
  **/
  @ApiModelProperty(required = true, value = "Identificador do currículo à qual o idioma está associado.")
  public String getResumeId() {
    return resumeId;
  }

  public void setResumeId(String resumeId) {
    this.resumeId = resumeId;
  }

  public LanguageSection language(String language) {
    this.language = language;
    return this;
  }

   /**
   * Idioma.
   * @return language
  **/
  @ApiModelProperty(required = true, value = "Idioma.")
  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public LanguageSection id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Identificador único da entidade.
   * @return id
  **/
  @ApiModelProperty(value = "Identificador único da entidade.")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public LanguageSection proficiency(LanguageProficiencyDto proficiency) {
    this.proficiency = proficiency;
    return this;
  }

   /**
   * Get proficiency
   * @return proficiency
  **/
  @ApiModelProperty(required = true, value = "")
  public LanguageProficiencyDto getProficiency() {
    return proficiency;
  }

  public void setProficiency(LanguageProficiencyDto proficiency) {
    this.proficiency = proficiency;
  }

  public LanguageSection updatedAt(OffsetDateTime updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }

   /**
   * Data da última alteração.
   * @return updatedAt
  **/
  @ApiModelProperty(value = "Data da última alteração.")
  public OffsetDateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(OffsetDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LanguageSection languageSection = (LanguageSection) o;
    return Objects.equals(this.createdAt, languageSection.createdAt) &&
        Objects.equals(this.resumeId, languageSection.resumeId) &&
        Objects.equals(this.language, languageSection.language) &&
        Objects.equals(this.id, languageSection.id) &&
        Objects.equals(this.proficiency, languageSection.proficiency) &&
        Objects.equals(this.updatedAt, languageSection.updatedAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(createdAt, resumeId, language, id, proficiency, updatedAt);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LanguageSection {\n");
    
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    resumeId: ").append(toIndentedString(resumeId)).append("\n");
    sb.append("    language: ").append(toIndentedString(language)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    proficiency: ").append(toIndentedString(proficiency)).append("\n");
    sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

