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
import io.swagger.client.model.DegreeDto;
import io.swagger.client.model.EducationStatusDto;
import java.io.IOException;
import org.threeten.bp.OffsetDateTime;

/**
 * EducationSection
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-07-15T17:37:52.386Z")
public class EducationSection {
  @SerializedName("createdAt")
  private OffsetDateTime createdAt = null;

  @SerializedName("resumeId")
  private String resumeId = null;

  @SerializedName("school")
  private String school = null;

  @SerializedName("degree")
  private DegreeDto degree = null;

  @SerializedName("conclusionYear")
  private Integer conclusionYear = null;

  @SerializedName("id")
  private String id = null;

  @SerializedName("fieldOfStudy")
  private String fieldOfStudy = null;

  @SerializedName("status")
  private EducationStatusDto status = null;

  @SerializedName("updatedAt")
  private OffsetDateTime updatedAt = null;

  public EducationSection createdAt(OffsetDateTime createdAt) {
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

  public EducationSection resumeId(String resumeId) {
    this.resumeId = resumeId;
    return this;
  }

   /**
   * Identificador do currículo a qual a educação está associada.
   * @return resumeId
  **/
  @ApiModelProperty(required = true, value = "Identificador do currículo a qual a educação está associada.")
  public String getResumeId() {
    return resumeId;
  }

  public void setResumeId(String resumeId) {
    this.resumeId = resumeId;
  }

  public EducationSection school(String school) {
    this.school = school;
    return this;
  }

   /**
   * Instituição de ensino.
   * @return school
  **/
  @ApiModelProperty(required = true, value = "Instituição de ensino.")
  public String getSchool() {
    return school;
  }

  public void setSchool(String school) {
    this.school = school;
  }

  public EducationSection degree(DegreeDto degree) {
    this.degree = degree;
    return this;
  }

   /**
   * Get degree
   * @return degree
  **/
  @ApiModelProperty(required = true, value = "")
  public DegreeDto getDegree() {
    return degree;
  }

  public void setDegree(DegreeDto degree) {
    this.degree = degree;
  }

  public EducationSection conclusionYear(Integer conclusionYear) {
    this.conclusionYear = conclusionYear;
    return this;
  }

   /**
   * Ano de conclusão.
   * @return conclusionYear
  **/
  @ApiModelProperty(value = "Ano de conclusão.")
  public Integer getConclusionYear() {
    return conclusionYear;
  }

  public void setConclusionYear(Integer conclusionYear) {
    this.conclusionYear = conclusionYear;
  }

  public EducationSection id(String id) {
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

  public EducationSection fieldOfStudy(String fieldOfStudy) {
    this.fieldOfStudy = fieldOfStudy;
    return this;
  }

   /**
   * Curso.
   * @return fieldOfStudy
  **/
  @ApiModelProperty(required = true, value = "Curso.")
  public String getFieldOfStudy() {
    return fieldOfStudy;
  }

  public void setFieldOfStudy(String fieldOfStudy) {
    this.fieldOfStudy = fieldOfStudy;
  }

  public EducationSection status(EducationStatusDto status) {
    this.status = status;
    return this;
  }

   /**
   * Get status
   * @return status
  **/
  @ApiModelProperty(required = true, value = "")
  public EducationStatusDto getStatus() {
    return status;
  }

  public void setStatus(EducationStatusDto status) {
    this.status = status;
  }

  public EducationSection updatedAt(OffsetDateTime updatedAt) {
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
    EducationSection educationSection = (EducationSection) o;
    return Objects.equals(this.createdAt, educationSection.createdAt) &&
        Objects.equals(this.resumeId, educationSection.resumeId) &&
        Objects.equals(this.school, educationSection.school) &&
        Objects.equals(this.degree, educationSection.degree) &&
        Objects.equals(this.conclusionYear, educationSection.conclusionYear) &&
        Objects.equals(this.id, educationSection.id) &&
        Objects.equals(this.fieldOfStudy, educationSection.fieldOfStudy) &&
        Objects.equals(this.status, educationSection.status) &&
        Objects.equals(this.updatedAt, educationSection.updatedAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(createdAt, resumeId, school, degree, conclusionYear, id, fieldOfStudy, status, updatedAt);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EducationSection {\n");
    
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    resumeId: ").append(toIndentedString(resumeId)).append("\n");
    sb.append("    school: ").append(toIndentedString(school)).append("\n");
    sb.append("    degree: ").append(toIndentedString(degree)).append("\n");
    sb.append("    conclusionYear: ").append(toIndentedString(conclusionYear)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    fieldOfStudy: ").append(toIndentedString(fieldOfStudy)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

