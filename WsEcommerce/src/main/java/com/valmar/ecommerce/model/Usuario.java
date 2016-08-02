package com.valmar.ecommerce.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "APELLIDO")
	private String apellido;
	
	@Column(name = "CORREO", unique=true)
	private String correo;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "GENERO")
	private String genero;
	
	@Column(name = "TIPO")
	private int tipo;
	
	@OneToOne
	@JoinColumn(name="ID_TIPO_DOCUMENTO")
	private TipoDocumento tipoDocumento; 
	
	@Column(name = "VALOR_DOCUMENTO")
	private String valorDocumento;
	
	@Column(name = "TELEFONO_LOCAL")
	private String telefonoLocal;	
	
	@Column(name = "TELEFONO_MOVIL")
	private String telefonoMovil;	
	
	@Column(name = "DIRECCION_FISCAL")
	private String direccionFiscal;	
	
	@Column(name = "FECHA_NACIMIENTO", updatable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaNacimiento;
	
	@OneToOne
	@JoinColumn(name="ID_DISTRITO")
	private Distrito distrito;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="ID_USUARIO")
	@JsonIgnore
    private Usuario usuario;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "usuario", cascade = CascadeType.ALL)
	@JsonBackReference
	private Set<Usuario> usuarios;
	
	
	@Column(name = "ESTADO")
	private int estado;	
	
	@Column(name = "FECHA_REGISTRO", updatable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaRegistro;
	
	@Column(name = "FECHA_MODIFICACION")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaModificacion;
	
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "cliente_direccion",
            joinColumns = {@JoinColumn(name = "ID_CLIENTE", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "ID_DIRECCION", referencedColumnName = "ID")})
	@Column(insertable=false, updatable=false)
    private Set<Direccion> direccionesCliente;
	
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "usuario_autoridad",
            joinColumns = {@JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "ID_AUTORIDAD", referencedColumnName = "ID")})
	@Column(insertable=false, updatable=false)
    private List<Authority> authorities;
	
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "tienda_usuario",
            joinColumns = {@JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "ID_TIENDA", referencedColumnName = "ID")})
	@Column(insertable=false, updatable=false)
    private Set<Tienda> tiendas;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public List<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public Set<Tienda> getTiendas() {
		return tiendas;
	}

	public void setTiendas(Set<Tienda> tiendas) {
		this.tiendas = tiendas;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public Set<Direccion> getDireccionesCliente() {
		return direccionesCliente;
	}

	public void setDireccionesCliente(Set<Direccion> direccionesCliente) {
		this.direccionesCliente = direccionesCliente;
	}

	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getValorDocumento() {
		return valorDocumento;
	}

	public void setValorDocumento(String valorDocumento) {
		this.valorDocumento = valorDocumento;
	}

	public String getTelefonoLocal() {
		return telefonoLocal;
	}

	public void setTelefonoLocal(String telefonoLocal) {
		this.telefonoLocal = telefonoLocal;
	}

	public String getTelefonoMovil() {
		return telefonoMovil;
	}

	public void setTelefonoMovil(String telefonoMovil) {
		this.telefonoMovil = telefonoMovil;
	}

	public String getDireccionFiscal() {
		return direccionFiscal;
	}

	public void setDireccionFiscal(String direccionFiscal) {
		this.direccionFiscal = direccionFiscal;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Distrito getDistrito() {
		return distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
		
}
