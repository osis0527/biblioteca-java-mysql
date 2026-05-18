import java.sql.*;

public class LibroDAO {

    // Agregar un libro
    public void agregar(String titulo, String isbn, int anio, int paginas, int stock, int idAutor, int idCategoria) {
        String sql = "INSERT INTO libros (titulo, isbn, anio_publicacion, num_paginas, stock, id_autor, id_categoria) VALUES (?, ?, ?, ?, ?, ?, ?)";
        Connection conexion = ConexionDB.getConexion();
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, titulo);
            ps.setString(2, isbn);
            ps.setInt(3, anio);
            ps.setInt(4, paginas);
            ps.setInt(5, stock);
            ps.setInt(6, idAutor);
            ps.setInt(7, idCategoria);
            ps.executeUpdate();
            System.out.println("✔ Libro \"" + titulo + "\" agregado correctamente.");
        } catch (SQLException e) {
            System.out.println("✘ Error al agregar libro: " + e.getMessage());
        } finally {
            ConexionDB.cerrarConexion(conexion);
        }
    }

    // Ver todos los libros
    public void verTodos() {
        String sql = "SELECT l.titulo, CONCAT(a.nombre, ' ', a.apellido) AS autor, c.nombre AS categoria, l.stock " +
                "FROM libros l " +
                "JOIN autores a ON l.id_autor = a.id_autor " +
                "JOIN categorias c ON l.id_categoria = c.id_categoria";
        Connection conexion = ConexionDB.getConexion();
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            System.out.println("\n=============================");
            System.out.println("  CATÁLOGO DE LIBROS");
            System.out.println("=============================");
            while (rs.next()) {
                System.out.println("────────────────────────────");
                System.out.println("Título:    " + rs.getString("titulo"));
                System.out.println("Autor:     " + rs.getString("autor"));
                System.out.println("Categoría: " + rs.getString("categoria"));
                System.out.println("Stock:     " + rs.getInt("stock"));
            }
        } catch (SQLException e) {
            System.out.println("✘ Error al consultar libros: " + e.getMessage());
        } finally {
            ConexionDB.cerrarConexion(conexion);
        }
    }

    // Actualizar stock de un libro
    public void actualizarStock(int idLibro, int nuevoStock) {
        String sql = "UPDATE libros SET stock = ? WHERE id_libro = ?";
        Connection conexion = ConexionDB.getConexion();
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, nuevoStock);
            ps.setInt(2, idLibro);
            ps.executeUpdate();
            System.out.println("✔ Stock actualizado correctamente.");
        } catch (SQLException e) {
            System.out.println("✘ Error al actualizar stock: " + e.getMessage());
        } finally {
            ConexionDB.cerrarConexion(conexion);
        }
    }

    // Eliminar un libro
    public void eliminar(int idLibro) {
        String sql = "DELETE FROM libros WHERE id_libro = ?";
        Connection conexion = ConexionDB.getConexion();
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, idLibro);
            ps.executeUpdate();
            System.out.println("✔ Libro eliminado correctamente.");
        } catch (SQLException e) {
            System.out.println("✘ Error al eliminar libro: " + e.getMessage());
        } finally {
            ConexionDB.cerrarConexion(conexion);
        }
    }
}