package com.unla.grupo37.servicios.implementacion;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.unla.grupo37.entidades.Compra;
import com.unla.grupo37.repositorios.ICompraRepositorio;
import com.unla.grupo37.servicios.IServicioGenerico;

import jakarta.transaction.Transactional;

@Service
public class CompraServicio implements IServicioGenerico<Compra>{
	
	private ICompraRepositorio repositorioCompra;
	
	public CompraServicio(ICompraRepositorio repositorioCompra) {
		this.repositorioCompra= repositorioCompra;
	}

	
	@Override
	@Transactional
	public List<Compra> findAll() throws Exception{
		try {
			List<Compra> entities= this.repositorioCompra.findAll();
			return entities;
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	@Override
	@Transactional
	public Compra findById(long id) throws Exception{
		try {
			Optional<Compra> opt= this.repositorioCompra.findById(id);
			return opt.get();
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	@Override
	@Transactional
	public Compra saveOne(Compra entity) throws Exception{
		try {
			Compra compra= this.repositorioCompra.save(entity);
			return compra;
		}catch(Exception e){
			throw new Exception(e.getMessage());
		}
	}
	
	@Override
	@Transactional
	public Compra updateOne(Compra entity, long id)throws Exception{
		try {
			Optional<Compra> opt= this.repositorioCompra.findById(id);
			Compra compra= opt.get();
			compra=this.repositorioCompra.save(entity);
			return compra;
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	@Override
	@Transactional
	public boolean deleteById(long id)throws Exception{
		try {
			Optional<Compra> opt= this.repositorioCompra.findById(id);
			if(! opt.isEmpty()) {
				Compra compra= opt.get();
				this.repositorioCompra.delete(compra);
			}else {
				throw new Exception("error al borrar");
			}
			
			return true;
			
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	
	
}
