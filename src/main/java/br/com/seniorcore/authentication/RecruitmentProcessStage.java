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
import io.swagger.client.model.ModelStage;
import io.swagger.client.model.Person;
import io.swagger.client.model.RecruitmentProcess;
import io.swagger.client.model.SeemMedicalStatusDto;
import java.io.IOException;
import org.threeten.bp.OffsetDateTime;

/**
 * RecruitmentProcessStage
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-07-15T19:10:27.342Z")
public class RecruitmentProcessStage {
  @SerializedName("process")
  private RecruitmentProcess process = null;

  @SerializedName("stage")
  private ModelStage stage = null;

  @SerializedName("processId")
  private String processId = null;

  @SerializedName("seemMedicalStatus")
  private SeemMedicalStatusDto seemMedicalStatus = null;

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

  @SerializedName("status")
  private AprovationTypeDto status = null;

  @SerializedName("stageId")
  private String stageId = null;

  public RecruitmentProcessStage process(RecruitmentProcess process) {
    this.process = process;
    return this;
  }

   /**
   * Get process
   * @return process
  **/
  @ApiModelProperty(value = "")
  public RecruitmentProcess getProcess() {
    return process;
  }

  public void setProcess(RecruitmentProcess process) {
    this.process = process;
  }

  public RecruitmentProcessStage stage(ModelStage stage) {
    this.stage = stage;
    return this;
  }

   /**
   * Get stage
   * @return stage
  **/
  @ApiModelProperty(value = "")
  public ModelStage getStage() {
    return stage;
  }

  public void setStage(ModelStage stage) {
    this.stage = stage;
  }

  public RecruitmentProcessStage processId(String processId) {
    this.processId = processId;
    return this;
  }

   /**
   * Identificador único do processo a qual está etapa pertence.
   * @return processId
  **/
  @ApiModelProperty(value = "Identificador único do processo a qual está etapa pertence.")
  public String getProcessId() {
    return processId;
  }

  public void setProcessId(String processId) {
    this.processId = processId;
  }

  public RecruitmentProcessStage seemMedicalStatus(SeemMedicalStatusDto seemMedicalStatus) {
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

  public RecruitmentProcessStage integrationStatus(IntegrationStatusDto integrationStatus) {
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

  public RecruitmentProcessStage integrationSendDate(OffsetDateTime integrationSendDate) {
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

  public RecruitmentProcessStage id(String id) {
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

  public RecruitmentProcessStage integrationResponsiblePersonId(String integrationResponsiblePersonId) {
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

  public RecruitmentProcessStage integrationG5Date(OffsetDateTime integrationG5Date) {
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

  public RecruitmentProcessStage integrationResponsiblePerson(Person integrationResponsiblePerson) {
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

  public RecruitmentProcessStage status(AprovationTypeDto status) {
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

  public RecruitmentProcessStage stageId(String stageId) {
    this.stageId = stageId;
    return this;
  }

   /**
   * Identificador único da etapa do processo seletivo.
   * @return stageId
  **/
  @ApiModelProperty(value = "Identificador único da etapa do processo seletivo.")
  public String getStageId() {
    return stageId;
  }

  public void setStageId(String stageId) {
    this.stageId = stageId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RecruitmentProcessStage recruitmentProcessStage = (RecruitmentProcessStage) o;
    return Objects.equals(this.process, recruitmentProcessStage.process) &&
        Objects.equals(this.stage, recruitmentProcessStage.stage) &&
        Objects.equals(this.processId, recruitmentProcessStage.processId) &&
        Objects.equals(this.seemMedicalStatus, recruitmentProcessStage.seemMedicalStatus) &&
        Objects.equals(this.integrationStatus, recruitmentProcessStage.integrationStatus) &&
        Objects.equals(this.integrationSendDate, recruitmentProcessStage.integrationSendDate) &&
        Objects.equals(this.id, recruitmentProcessStage.id) &&
        Objects.equals(this.integrationResponsiblePersonId, recruitmentProcessStage.integrationResponsiblePersonId) &&
        Objects.equals(this.integrationG5Date, recruitmentProcessStage.integrationG5Date) &&
        Objects.equals(this.integrationResponsiblePerson, recruitmentProcessStage.integrationResponsiblePerson) &&
        Objects.equals(this.status, recruitmentProcessStage.status) &&
        Objects.equals(this.stageId, recruitmentProcessStage.stageId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(process, stage, processId, seemMedicalStatus, integrationStatus, integrationSendDate, id, integrationResponsiblePersonId, integrationG5Date, integrationResponsiblePerson, status, stageId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RecruitmentProcessStage {\n");
    
    sb.append("    process: ").append(toIndentedString(process)).append("\n");
    sb.append("    stage: ").append(toIndentedString(stage)).append("\n");
    sb.append("    processId: ").append(toIndentedString(processId)).append("\n");
    sb.append("    seemMedicalStatus: ").append(toIndentedString(seemMedicalStatus)).append("\n");
    sb.append("    integrationStatus: ").append(toIndentedString(integrationStatus)).append("\n");
    sb.append("    integrationSendDate: ").append(toIndentedString(integrationSendDate)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    integrationResponsiblePersonId: ").append(toIndentedString(integrationResponsiblePersonId)).append("\n");
    sb.append("    integrationG5Date: ").append(toIndentedString(integrationG5Date)).append("\n");
    sb.append("    integrationResponsiblePerson: ").append(toIndentedString(integrationResponsiblePerson)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    stageId: ").append(toIndentedString(stageId)).append("\n");
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

