package innotech.com.sv.modelosDao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import innotech.com.sv.modelos.Empresa;
import innotech.com.sv.modelos.Ocupacion;

public interface OcupacionDao  extends PagingAndSortingRepository<Ocupacion, Long>{
	public List<Ocupacion> findByEmpresa(Empresa empresa);
	
	@Query(value = "select * from ocupaciones p where p.empresa_id= ?1  and p.estado = 0 ", nativeQuery = true) 
	public Page<Ocupacion> findAllByEmpresa(long empresa, Pageable pageable ); 
	
	
		
}
