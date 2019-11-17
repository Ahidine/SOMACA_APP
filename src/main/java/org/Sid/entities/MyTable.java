package org.Sid.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class MyTable implements Serializable {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	private String departement ;
	private String equipement ;
	private String sous_equipement;
	private String designation ;
	private String reference  ;
	private String etat_PDR;
	private String Type_PDR  ; 
	public String getType_PDR() {
		return Type_PDR;
	}
	public void setType_PDR(String type_PDR) {
		Type_PDR = type_PDR;
	}
	private String code_mabic ;
	private String mode_gestionnaire ;
	public MyTable() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MyTable(String departement, String equipement, String sous_equipement, String designation, String reference,
			String etat_PDR, String code_mabic, String mode_gestionnaire ,String Type_PDR) {
		super();
		this.departement = departement;
		this.equipement = equipement;
		this.sous_equipement = sous_equipement;
		this.designation = designation;
		this.reference = reference;
		this.etat_PDR = etat_PDR;
		this.code_mabic = code_mabic;
		this.mode_gestionnaire = mode_gestionnaire;
		this.Type_PDR=Type_PDR;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDepartement() {
		return departement;
	}
	public void setDepartement(String departement) {
		this.departement = departement;
	}
	public String getEquipement() {
		return equipement;
	}
	public void setEquipement(String equipement) {
		this.equipement = equipement;
	}
	public String getSous_equipement() {
		return sous_equipement;
	}
	public void setSous_equipement(String sous_equipement) {
		this.sous_equipement = sous_equipement;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getEtat_PDR() {
		return etat_PDR;
	}
	public void setEtat_PDR(String etat_PDR) {
		this.etat_PDR = etat_PDR;
	}
	public String getCode_mabic() {
		return code_mabic;
	}
	public void setCode_mabic(String code_mabic) {
		this.code_mabic = code_mabic;
	}
	public String getMode_gestionnaire() {
		return mode_gestionnaire;
	}
	public void setMode_gestionnaire(String mode_gestionnaire) {
		this.mode_gestionnaire = mode_gestionnaire;
	}

	
	
}
