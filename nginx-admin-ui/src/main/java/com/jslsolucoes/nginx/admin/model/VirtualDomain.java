package com.jslsolucoes.nginx.admin.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "virtual_domain", schema = "admin")
public class VirtualDomain implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "domain")
	private String domain;

	@Column(name = "https")
	private Integer https;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_ssl_certificate")
	private SslCertificate sslCertificate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_upstream")
	private Upstream upstream;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_resource_identifier")
	private ResourceIdentifier resourceIdentifier;

	public VirtualDomain() {

	}
	
	public VirtualDomain(Long id) {
		this.id = id;
	}

	public VirtualDomain(Long id, String domain, Integer https, SslCertificate sslCertificate, Upstream upstream,
			ResourceIdentifier resourceIdentifier) {
		this.id = id;
		this.domain = domain;
		this.https = (https == null ? 0 : https);
		this.sslCertificate = sslCertificate;
		this.upstream = upstream;
		this.resourceIdentifier = resourceIdentifier;
	}

	public VirtualDomain(String domain, Integer https, SslCertificate sslCertificate, Upstream upstream) {
		this.domain = domain;
		this.https = https;
		this.sslCertificate = sslCertificate;
		this.upstream = upstream;
	}

	public VirtualDomain(String domain) {
		this.domain = domain;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public Integer getHttps() {
		return https;
	}

	public void setHttps(Integer https) {
		this.https = https;
	}

	public SslCertificate getSslCertificate() {
		return sslCertificate;
	}

	public void setSslCertificate(SslCertificate sslCertificate) {
		this.sslCertificate = sslCertificate;
	}

	public Upstream getUpstream() {
		return upstream;
	}

	public void setUpstream(Upstream upstream) {
		this.upstream = upstream;
	}

	public ResourceIdentifier getResourceIdentifier() {
		return resourceIdentifier;
	}

	public void setResourceIdentifier(ResourceIdentifier resourceIdentifier) {
		this.resourceIdentifier = resourceIdentifier;
	}

}
