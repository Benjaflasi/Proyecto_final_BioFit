package objetos;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Arrays;
import java.util.Objects;

public class insumosB {

    private int id;
    private String[] productos ={"proteina","mancuernas","barra","guantes","poleras"};
     private int[] precios ={20000,30000,24500,5000,7000};
     private int Stock;

    public insumosB() {
    }

    public insumosB(int id, String[] productos, int[] precios, int stock) {
        this.id = id;
        this.productos = productos;
        this.precios = precios;
        Stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String[] getProductos() {
        return productos;
    }

    public void setProductos(String[] productos) {
        this.productos = productos;
    }

    public int[] getPrecios() {
        return precios;
    }

    public void setPrecios(int[] precios) {
        this.precios = precios;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int stock) {
        Stock = stock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof insumosB)) return false;
        insumosB insumosB = (insumosB) o;
        return id == insumosB.id && Stock == insumosB.Stock && Arrays.equals(productos, insumosB.productos) && Arrays.equals(precios, insumosB.precios);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, Stock);
        result = 31 * result + Arrays.hashCode(productos);
        result = 31 * result + Arrays.hashCode(precios);
        return result;
    }

    @Override
    public String toString() {
        return "insumosB{" +
                "id=" + id +
                ", productos=" + Arrays.toString(productos) +
                ", precios=" + Arrays.toString(precios) +
                ", Stock=" + Stock +
                '}';
    }

    public int calcularvalor1(int cantidad, int tipo) {
        int resultado = cantidad+tipo;
        return resultado;
    }
}
