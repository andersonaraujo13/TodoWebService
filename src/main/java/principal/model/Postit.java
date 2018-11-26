package principal.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Postit implements Serializable{
	
	private static final long serialVersionUID = 1473105742621897584L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	
	@Column(name = "st_apelido")
	private String stApelido;
	
	@Column(name = "st_descricao")
	private String stDescricao;
	
	@Column(name = "st_background")
	private String stBackground;
	
	@Column(name = "bo_finalizado")
	private boolean boFinalizado;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE} ,mappedBy = "cePostit", orphanRemoval = true)
	private List<Task> listTarefas;
	
	public String getStApelido() {
		return stApelido;
	}
	public void setStApelido(String stApelido) {
		this.stApelido = stApelido;
	}
	public String getStDescricao() {
		return stDescricao;
	}
	public void setStDescricao(String stDescricao) {
		this.stDescricao = stDescricao;
	}
	public String getStBackground() {
		return stBackground;
	}
	public void setStBackground(String stBackground) {
		this.stBackground = stBackground;
	}
	public boolean isBoFinalizado() {
		return boFinalizado;
	}
	public void setBoFinalizado(boolean boFinalizado) {
		this.boFinalizado = boFinalizado;
	}
	public List<Task> getListTarefas() {
		return listTarefas;
	}
	public void setListTarefas(List<Task> listTarefas) {
		this.listTarefas = listTarefas;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	

}
