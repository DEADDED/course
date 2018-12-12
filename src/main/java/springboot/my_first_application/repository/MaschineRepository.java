package springboot.my_first_application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import springboot.my_first_application.model.Maschine;


public interface MaschineRepository extends JpaRepository<Maschine, Long>{

}
