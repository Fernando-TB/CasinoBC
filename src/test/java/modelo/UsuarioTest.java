package modelo;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {

    @Test
    void validarCredenciales() {

        Usuario user = new Usuario("ft", "123", "fernan");

        boolean res = user.validarCredenciales(null, "123");

        assertFalse(res);
    }

}