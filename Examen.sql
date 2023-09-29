

CREATE TABLE empleados (
    IdEmpleado INT (20) NOT NULL,
    Apellidos VARCHAR(60) NOT NULL,
    Nombres VARCHAR(60) NOT NULL,
    Edad INT NOT NULL,
    Sexo VARCHAR(20) NOT NULL,
    Salario DOUBLE(10) NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO `empleados` (`IdEmpleado`, `Apellidos`, `Nombres`, `Edad`, `Sexo`, `Salario`) VALUES
(1, 'Anastacio', 'Marco Antonio', 19, 'masculino', 3500);

ALTER TABLE `empleados`
  ADD PRIMARY KEY (`IdEmpleado`);

ALTER TABLE `empleados`
  MODIFY `IdEmpleado` int(99) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;
