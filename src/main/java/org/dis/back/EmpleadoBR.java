package org.dis.back;

public class EmpleadoBR {


    public EmpleadoBR() {
    }

    public float calculaSalarioBruto(
            String tipo,
            float ventasMes,
            float horasExtra) throws BRException {

        if (tipo==null || tipo=="" || ventasMes < 0 || horasExtra < 0) {
            throw new BRException("Valores de entrada no válidos");
        }

        float total_salario = 0;

        if (tipo.equals(TipoEmpleado.vendedor)){
            total_salario += TipoEmpleado.sueldo_base_vendedor;
        } else if (tipo.equals(TipoEmpleado.encargado)){
            total_salario += TipoEmpleado.sueldo_base_encargado;
        }

        if (ventasMes >= 1000 && ventasMes < 1500) {
            total_salario += 100;
        } else if (ventasMes >= 1500) {
            total_salario += 200;
        }

        float salario_extra = horasExtra * TipoEmpleado.precio_hora;

        total_salario += salario_extra;
        return total_salario;

    }

    public float calculaSalarioNeto (float salarioBruto) throws BRException{

        if(salarioBruto < 0){
            throw new BRException("Salario neto total menor que 0");
        }

        float salarioNeto = (float) 0.0;
        if (salarioBruto <1000.0){
            salarioNeto = (float) 1000.0;

        }else if (salarioBruto >= 1000 && salarioBruto < 1500){
            salarioNeto = (float) ((float) salarioBruto * (1 - 0.16));
        }else if (salarioBruto >= 1500){
            salarioNeto = (float) ((float) salarioBruto * (1 - 0.18));
        }

        return salarioNeto;
    }


}
