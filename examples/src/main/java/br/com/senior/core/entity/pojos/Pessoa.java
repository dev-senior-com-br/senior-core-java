package br.com.senior.core.entity.pojos;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.util.List;

import com.google.gson.annotations.SerializedName;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Getter
@ToString(onlyExplicitlyIncluded = true)
public class Pessoa {

    @ToString.Include
    String id;
    @SerializedName("apePes")
    String nomeFantasia;
    String cnpCpf;
    int codPes;
    String codSuf;
    List custom;
    @ToString.Include
    @SerializedName("nomPes")
    String nome;
    @SerializedName("sitPes")
    String situacao;
    String tipMer;
    @SerializedName("tipPes")
    String tipo;

    boolean excluido;

}
