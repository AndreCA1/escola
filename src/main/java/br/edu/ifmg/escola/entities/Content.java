package br.edu.ifmg.escola.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
//Como foi usado JOINED, será criado uma tabela para o filho
@Table(name = "tb_content")
public class Content extends Lesson{
    private String textContent;
    private Integer approvalCount;
}
