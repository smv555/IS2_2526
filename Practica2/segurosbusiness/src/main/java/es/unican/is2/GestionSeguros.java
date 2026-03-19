package es.unican.is2;

import java.util.List;

public class GestionSeguros implements IGestionSeguros, IGestionClientes, IInfoSeguros{


    private IClientesDAO clientesDAO;
    private ISegurosDAO segurosDAO;


    public GestionSeguros(IClientesDAO daoClientes, ISegurosDAO daoSeguros) {
        clientesDAO = daoClientes;
        segurosDAO = daoSeguros;
    }

    @Override
    public Seguro nuevoSeguro(Seguro s, String dni) throws OperacionNoValida, DataAccessException {
        // TODO Auto-generated method stub

        Cliente c;

        try {
            c = clientesDAO.cliente(dni);
        } catch (DataAccessException e) {
            // TODO: handle exception
            throw new DataAccessException();
        }

        try {
            if (segurosDAO.seguros().contains(s)) {
                throw new OperacionNoValida("Error. El seguro  ya existe");
            }
        } catch (DataAccessException e) {
            // TODO: handle exception
            throw new DataAccessException();
        }

        if (c == null) {
            return null;
        }

        segurosDAO.creaSeguro(s);
        List<Seguro> seguros = c.getSeguros();
        seguros.add(s);
        c.setSeguros(seguros);
        clientesDAO.actualizaCliente(c);
        segurosDAO.actualizaSeguro(s);

        return s;
    }

    @Override
    public Seguro bajaSeguro(String matricula, String dni) throws OperacionNoValida, DataAccessException {
        // TODO Auto-generated method stub
        Seguro s;
        Cliente c;
        try {
            s = segurosDAO.seguroPorMatricula(matricula);
        } catch (DataAccessException e) {
            // TODO: handle exception
            throw new DataAccessException();
        }
        if (s == null) {
            return null;
        }

        try {
            c = clientesDAO.cliente(dni);
        } catch (DataAccessException e) {
            // TODO: handle exception
            throw new DataAccessException();
        }
        if (c == null) {
            return null;
        }

        if (!c.getSeguros().contains(s)) {
            throw new OperacionNoValida("Error. El seguro indicado no pertenece al cliente indicado");
        }
        try {
            Seguro seg = segurosDAO.eliminaSeguro(s.getId());
            segurosDAO.actualizaSeguro(seg);
            return seg;
        } catch (DataAccessException e) {
            throw new DataAccessException();
        }

        // TODO: Preguntar si hay que actualizar cliente o seguro aqui
    }

    @Override
    public Seguro anhadeConductorAdicional(String matricula, String conductor) throws DataAccessException {
        // TODO Auto-generated method stub
        try {
            Seguro s = segurosDAO.seguroPorMatricula(matricula);
            if (s != null) {
                s.setConductorAdicional(conductor);
                segurosDAO.actualizaSeguro(s);
            }
                
            return s;

        } catch (DataAccessException e) {
            throw new DataAccessException();
        }
    }

    @Override
    public Cliente nuevoCliente(Cliente c) throws DataAccessException {
        // TODO Auto-generated method stub
        try {
            return clientesDAO.actualizaCliente(clientesDAO.creaCliente(c));
        } catch (DataAccessException e) {
            throw new DataAccessException();
        }
        // TODO: Preguntar si hay que actualizar cliente aqui
    }

    @Override
    public Cliente bajaCliente(String dni) throws OperacionNoValida, DataAccessException {
        // TODO Auto-generated method stub
         try {
            Cliente c = clientesDAO.cliente(dni);
            
            if (c.getSeguros().isEmpty()){
                clientesDAO.eliminaCliente(dni);
                clientesDAO.actualizaCliente(c);
                return c;
            } else {
                throw new OperacionNoValida("Hay un seguro asociado al cliente");
            }
            
        
        } catch (DataAccessException e) {
            // TODO Auto-generated catch block
            throw new DataAccessException();
        }
    }

    @Override
    public Cliente cliente(String dni) throws DataAccessException {
        // TODO Auto-generated method stub
        try {
            Cliente c = clientesDAO.cliente(dni);
            return c;
        } catch (DataAccessException e) {
            // TODO Auto-generated catch block
            throw new DataAccessException();
        }
    }

    @Override
    public Seguro seguro(String matricula) throws DataAccessException {
        // TODO Auto-generated method stub

        try {
            Seguro s = segurosDAO.seguroPorMatricula(matricula);
            return s;
        } catch (DataAccessException e) {
            // TODO: handle exception
            throw new DataAccessException();
        }



        
    }

}
