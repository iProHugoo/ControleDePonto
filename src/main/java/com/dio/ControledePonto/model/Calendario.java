package com.dio.ControledePonto.model;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
@Audited
public class Calendario {
	@Id
	private Long id;
	private String descricao;
	@ManyToOne
	private TipoData tipoData;
	private LocalDateTime dataEspecial;
}
