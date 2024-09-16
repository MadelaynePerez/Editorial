/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Querys;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author DELL
 */
public interface IBaseCrud <T> {
      public boolean crear(T entidad );
    public T eliminar (Long id);
    public boolean actualizar (T Actualizar);
    public ArrayList<T> listar ();
    public T encontrarPorId(Long id);
}
