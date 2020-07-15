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
import io.swagger.client.model.PersonalityModelCandidate;
import java.io.IOException;

/**
 * Values
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-07-15T19:10:27.342Z")
public class Values {
  @SerializedName("selfEnhancement")
  private Double selfEnhancement = null;

  @SerializedName("conservation")
  private Double conservation = null;

  @SerializedName("opennessToChange")
  private Double opennessToChange = null;

  @SerializedName("personalityModelCandidate")
  private PersonalityModelCandidate personalityModelCandidate = null;

  @SerializedName("selfTranscendence")
  private Double selfTranscendence = null;

  @SerializedName("hedonism")
  private Double hedonism = null;

  @SerializedName("id")
  private String id = null;

  public Values selfEnhancement(Double selfEnhancement) {
    this.selfEnhancement = selfEnhancement;
    return this;
  }

   /**
   * Auto-crescimento.
   * @return selfEnhancement
  **/
  @ApiModelProperty(required = true, value = "Auto-crescimento.")
  public Double getSelfEnhancement() {
    return selfEnhancement;
  }

  public void setSelfEnhancement(Double selfEnhancement) {
    this.selfEnhancement = selfEnhancement;
  }

  public Values conservation(Double conservation) {
    this.conservation = conservation;
    return this;
  }

   /**
   * Conservação.
   * @return conservation
  **/
  @ApiModelProperty(required = true, value = "Conservação.")
  public Double getConservation() {
    return conservation;
  }

  public void setConservation(Double conservation) {
    this.conservation = conservation;
  }

  public Values opennessToChange(Double opennessToChange) {
    this.opennessToChange = opennessToChange;
    return this;
  }

   /**
   * Abertura à mudança.
   * @return opennessToChange
  **/
  @ApiModelProperty(required = true, value = "Abertura à mudança.")
  public Double getOpennessToChange() {
    return opennessToChange;
  }

  public void setOpennessToChange(Double opennessToChange) {
    this.opennessToChange = opennessToChange;
  }

  public Values personalityModelCandidate(PersonalityModelCandidate personalityModelCandidate) {
    this.personalityModelCandidate = personalityModelCandidate;
    return this;
  }

   /**
   * Get personalityModelCandidate
   * @return personalityModelCandidate
  **/
  @ApiModelProperty(value = "")
  public PersonalityModelCandidate getPersonalityModelCandidate() {
    return personalityModelCandidate;
  }

  public void setPersonalityModelCandidate(PersonalityModelCandidate personalityModelCandidate) {
    this.personalityModelCandidate = personalityModelCandidate;
  }

  public Values selfTranscendence(Double selfTranscendence) {
    this.selfTranscendence = selfTranscendence;
    return this;
  }

   /**
   * Auto-transcendência.
   * @return selfTranscendence
  **/
  @ApiModelProperty(required = true, value = "Auto-transcendência.")
  public Double getSelfTranscendence() {
    return selfTranscendence;
  }

  public void setSelfTranscendence(Double selfTranscendence) {
    this.selfTranscendence = selfTranscendence;
  }

  public Values hedonism(Double hedonism) {
    this.hedonism = hedonism;
    return this;
  }

   /**
   * Hedonismo.
   * @return hedonism
  **/
  @ApiModelProperty(required = true, value = "Hedonismo.")
  public Double getHedonism() {
    return hedonism;
  }

  public void setHedonism(Double hedonism) {
    this.hedonism = hedonism;
  }

  public Values id(String id) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Values values = (Values) o;
    return Objects.equals(this.selfEnhancement, values.selfEnhancement) &&
        Objects.equals(this.conservation, values.conservation) &&
        Objects.equals(this.opennessToChange, values.opennessToChange) &&
        Objects.equals(this.personalityModelCandidate, values.personalityModelCandidate) &&
        Objects.equals(this.selfTranscendence, values.selfTranscendence) &&
        Objects.equals(this.hedonism, values.hedonism) &&
        Objects.equals(this.id, values.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(selfEnhancement, conservation, opennessToChange, personalityModelCandidate, selfTranscendence, hedonism, id);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Values {\n");
    
    sb.append("    selfEnhancement: ").append(toIndentedString(selfEnhancement)).append("\n");
    sb.append("    conservation: ").append(toIndentedString(conservation)).append("\n");
    sb.append("    opennessToChange: ").append(toIndentedString(opennessToChange)).append("\n");
    sb.append("    personalityModelCandidate: ").append(toIndentedString(personalityModelCandidate)).append("\n");
    sb.append("    selfTranscendence: ").append(toIndentedString(selfTranscendence)).append("\n");
    sb.append("    hedonism: ").append(toIndentedString(hedonism)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
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

