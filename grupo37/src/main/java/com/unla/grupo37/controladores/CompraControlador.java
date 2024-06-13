package com.unla.grupo37.controladores;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.unla.grupo37.ayudante.AyudanteRutasVistas;
import com.unla.grupo37.dtos.ProductoDTO;
import com.unla.grupo37.entidades.Compra;
import com.unla.grupo37.servicios.implementacion.CompraServicio;
import com.unla.grupo37.servicios.implementacion.ProductoServicio;

@Controller
@RequestMapping("/compra")
public class CompraControlador {
	
	private CompraServicio compraServicio;
	private ProductoServicio productoServicio;
	
	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(AyudanteRutasVistas.COMPRA_INDEX);
		List<ProductoDTO> listaProductos= productoServicio.findAll();
		mAV.addObject("productos", listaProductos);
		
		return mAV;
	}
	
	@PostMapping("/")
	public Compra finalizarCompra(@RequestParam Compra compra) throws Exception {
		
		Compra returnCompra=compraServicio.saveOne(compra);
		return returnCompra;
	}
	
	

}
