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
import io.swagger.client.model.AprovationTypeDto;
import io.swagger.client.model.IntegrationStatusDto;
import io.swagger.client.model.Person;
import io.swagger.client.model.RecruitmentProcessStage;
import io.swagger.client.model.SeemMedicalStatusDto;
import java.io.IOException;
import org.threeten.bp.OffsetDateTime;

/**
 * RecruitmentProcessStageHistory
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-07-15T19:13:46.928Z")
public class RecruitmentProcessStageHistory {
  @SerializedName("seemMedicalStatus")
  private SeemMedicalStatusDto seemMedicalStatus = null;

  @SerializedName("avaliator")
  private Person avaliator = null;

  @SerializedName("comment")
  private String comment = null;

  @SerializedName("integrationStatus")
  private IntegrationStatusDto integrationStatus = null;

  @SerializedName("integrationSendDate")
  private OffsetDateTime integrationSendDate = null;

  @SerializedName("id")
  private String id = null;

  @SerializedName("integrationResponsiblePersonId")
  private String integrationResponsiblePersonId = null;

  @SerializedName("integrationG5Date")
  private OffsetDateTime integrationG5Date = null;

  @SerializedName("integrationResponsiblePerson")
  private Person integrationResponsiblePerson = null;

  @SerializedName("stageId")
  private RecruitmentProcessStage stageId = null;

  @SerializedName("username")
  private String username = null;

  @SerializedName("status")
  private AprovationTypeDto status = null;

  public RecruitmentProcessStageHistory seemMedicalStatus(SeemMedicalStatusDto seemMedicalStatus) {
    this.seemMedicalStatus = seemMedicalStatus;
    return this;
  }

   /**
   * Get seemMedicalStatus
   * @return seemMedicalStatus
  **/
  @ApiModelProperty(value = "")
  public SeemMedicalStatusDto getSeemMedicalStatus() {
    return seemMedicalStatus;
  }

  public void setSeemMedicalStatus(SeemMedicalStatusDto seemMedicalStatus) {
    this.seemMedicalStatus = seemMedicalStatus;
  }

  public RecruitmentProcessStageHistory avaliator(Person avaliator) {
    this.avaliator = avaliator;
    return this;
  }

   /**
   * Get avaliator
   * @return avaliator
  **/
  @ApiModelProperty(value = "")
  public Person getAvaliator() {
    return avaliator;
  }

  public void setAvaliator(Person avaliator) {
    this.avaliator = avaliator;
  }

  public RecruitmentProcessStageHistory comment(String comment) {
    this.comment = comment;
    return this;
  }

   /**
   * comentario da etapa
   * @return comment
  **/
  @ApiModelProperty(value = "comentario da etapa")
  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public RecruitmentProcessStageHistory integrationStatus(IntegrationStatusDto integrationStatus) {
    this.integrationStatus = integrationStatus;
    return this;
  }

   /**
   * Get integrationStatus
   * @return integrationStatus
  **/
  @ApiModelProperty(value = "")
  public IntegrationStatusDto getIntegrationStatus() {
    return integrationStatus;
  }

  public void setIntegrationStatus(IntegrationStatusDto integrationStatus) {
    this.integrationStatus = integrationStatus;
  }

  public RecruitmentProcessStageHistory integrationSendDate(OffsetDateTime integrationSendDate) {
    this.integrationSendDate = integrationSendDate;
    return this;
  }

   /**
   * Data e hora de envio das informações para gerar a ficha médica e ASO.
   * @return integrationSendDate
  **/
  @ApiModelProperty(value = "Data e hora de envio das informações para gerar a ficha médica e ASO.")
  public OffsetDateTime getIntegrationSendDate() {
    return integrationSendDate;
  }

  public void setIntegrationSendDate(OffsetDateTime integrationSendDate) {
    this.integrationSendDate = integrationSendDate;
  }

  public RecruitmentProcessStageHistory id(String id) {
    this.id = id;
    return this;
  }

   /**
   * identificador unico da entidade
   * @return id
  **/
  @ApiModelProperty(value = "identificador unico da entidade")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public RecruitmentProcessStageHistory integrationResponsiblePersonId(String integrationResponsiblePersonId) {
    this.integrationResponsiblePersonId = integrationResponsiblePersonId;
    return this;
  }

   /**
   * Identificador único do responsável por gerar a ficha médica e ASO.
   * @return integrationResponsiblePersonId
  **/
  @ApiModelProperty(value = "Identificador único do responsável por gerar a ficha médica e ASO.")
  public String getIntegrationResponsiblePersonId() {
    return integrationResponsiblePersonId;
  }

  public void setIntegrationResponsiblePersonId(String integrationResponsiblePersonId) {
    this.integrationResponsiblePersonId = integrationResponsiblePersonId;
  }

  public RecruitmentProcessStageHistory integrationG5Date(OffsetDateTime integrationG5Date) {
    this.integrationG5Date = integrationG5Date;
    return this;
  }

   /**
   * Data e hora de recepção da G5 do parecer da ficha médica e ASO.
   * @return integrationG5Date
  **/
  @ApiModelProperty(value = "Data e hora de recepção da G5 do parecer da ficha médica e ASO.")
  public OffsetDateTime getIntegrationG5Date() {
    return integrationG5Date;
  }

  public void setIntegrationG5Date(OffsetDateTime integrationG5Date) {
    this.integrationG5Date = integrationG5Date;
  }

  public RecruitmentProcessStageHistory integrationResponsiblePerson(Person integrationResponsiblePerson) {
    this.integrationResponsiblePerson = integrationResponsiblePerson;
    return this;
  }

   /**
   * Get integrationResponsiblePerson
   * @return integrationResponsiblePerson
  **/
  @ApiModelProperty(value = "")
  public Person getIntegrationResponsiblePerson() {
    return integrationResponsiblePerson;
  }

  public void setIntegrationResponsiblePerson(Person integrationResponsiblePerson) {
    this.integrationResponsiblePerson = integrationResponsiblePerson;
  }

  public RecruitmentProcessStageHistory stageId(RecruitmentProcessStage stageId) {
    this.stageId = stageId;
    return this;
  }

   /**
   * Get stageId
   * @return stageId
  **/
  @ApiModelProperty(value = "")
  public RecruitmentProcessStage getStageId() {
    return stageId;
  }

  public void setStageId(RecruitmentProcessStage stageId) {
    this.stageId = stageId;
  }

  public RecruitmentProcessStageHistory username(String username) {
    this.username = username;
    return this;
  }

   /**
   * username do usuario
   * @return username
  **/
  @ApiModelProperty(value = "username do usuario")
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public RecruitmentProcessStageHistory status(AprovationTypeDto status) {
    this.status = status;
    return this;
  }

   /**
   * Get status
   * @return status
  **/
  @ApiModelProperty(value = "")
  public AprovationTypeDto getStatus() {
    return status;
  }

  public void setStatus(AprovationTypeDto status) {
    this.status = status;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RecruitmentProcessStageHistory recruitmentProcessStageHistory = (RecruitmentProcessStageHistory) o;
    return Objects.equals(this.seemMedicalStatus, recruitmentProcessStageHistory.seemMedicalStatus) &&
        Objects.equals(this.avaliator, recruitmentProcessStageHistory.avaliator) &&
        Objects.equals(this.comment, recruitmentProcessStageHistory.comment) &&
        Objects.equals(this.integrationStatus, recruitmentProcessStageHistory.integrationStatus) &&
        Objects.equals(this.integrationSendDate, recruitmentProcessStageHistory.integrationSendDate) &&
        Objects.equals(this.id, recruitmentProcessStageHistory.id) &&
        Objects.equals(this.integrationResponsiblePersonId, recruitmentProcessStageHistory.integrationResponsiblePersonId) &&
        Objects.equals(this.integrationG5Date, recruitmentProcessStageHistory.integrationG5Date) &&
        Objects.equals(this.integrationResponsiblePerson, recruitmentProcessStageHistory.integrationResponsiblePerson) &&
        Objects.equals(this.stageId, recruitmentProcessStageHistory.stageId) &&
        Objects.equals(this.username, recruitmentProcessStageHistory.username) &&
        Objects.equals(this.status, recruitmentProcessStageHistory.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(seemMedicalStatus, avaliator, comment, integrationStatus, integrationSendDate, id, integrationResponsiblePersonId, integrationG5Date, integrationResponsiblePerson, stageId, username, status);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RecruitmentProcessStageHistory {\n");
    
    sb.append("    seemMedicalStatus: ").append(toIndentedString(seemMedicalStatus)).append("\n");
    sb.append("    avaliator: ").append(toIndentedString(avaliator)).append("\n");
    sb.append("    comment: ").append(toIndentedString(comment)).append("\n");
    sb.append("    integrationStatus: ").append(toIndentedString(integrationStatus)).append("\n");
    sb.append("    integrationSendDate: ").append(toIndentedString(integrationSendDate)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    integrationResponsiblePersonId: ").append(toIndentedString(integrationResponsiblePersonId)).append("\n");
    sb.append("    integrationG5Date: ").append(toIndentedString(integrationG5Date)).append("\n");
    sb.append("    integrationResponsiblePerson: ").append(toIndentedString(integrationResponsiblePerson)).append("\n");
    sb.append("    stageId: ").append(toIndentedString(stageId)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

