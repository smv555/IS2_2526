package es.unican.is2;
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
        throw new UnsupportedOperationException("Unimplemented method 'nuevoSeguro'");
    }

    @Override
    public Seguro bajaSeguro(String matricula, String dni) throws OperacionNoValida, DataAccessException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'bajaSeguro'");
    }

    @Override
    public Seguro anhadeConductorAdicional(String matricula, String conductor) throws DataAccessException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'anhadeConductorAdicional'");
    }

    @Override
    public Cliente nuevoCliente(Cliente c) throws DataAccessException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'nuevoCliente'");
    }

    @Override
    public Cliente bajaCliente(String dni) throws OperacionNoValida, DataAccessException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'bajaCliente'");
    }

    @Override
    public Cliente cliente(String dni) throws DataAccessException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cliente'");
    }

    @Override
    public Seguro seguro(String matricula) throws DataAccessException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'seguro'");
    }

}
