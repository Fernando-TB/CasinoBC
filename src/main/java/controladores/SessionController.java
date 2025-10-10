package controladores;

import modelo.Usuario;

public class SessionController {
    private Usuario usuario;

    public SessionController(Usuario usuario){
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }
}
