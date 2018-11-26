package principal.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Task implements Serializable{

	private static final long serialVersionUID = -4949473102280879863L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(name = "st_descricao")
	private String stDescricao;
	
	@Column(name = "bo_finalizado")
	private boolean boFinalizado;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ce_postit")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Postit cePostit;
	
	public String getStDescricao() {
		return stDescricao;
	}
	public void setStDescricao(String stDescricao) {
		this.stDescricao = stDescricao;
	}
	public boolean isBoFinalizado() {
		return boFinalizado;
	}
	public void setBoFinalizado(boolean boFinalizado) {
		this.boFinalizado = boFinalizado;
	}
	public Postit getCePostit() {
		return cePostit;
	}
	public void setCePostit(Postit cePostit) {
		this.cePostit = cePostit;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
		

}
