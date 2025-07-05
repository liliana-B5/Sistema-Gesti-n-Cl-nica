use dawa;

CREATE TABLE Usuario (
    id_usuario INT NOT NULL AUTO_INCREMENT,
    cedula VARCHAR(10) NOT NULL,
    contrasena VARCHAR(255) NOT NULL,
    PRIMARY KEY (id_usuario),
    UNIQUE KEY (cedula),
    FOREIGN KEY (cedula) REFERENCES Persona(cedula)
);
-- Tabla persona
CREATE TABLE Persona (
    cedula VARCHAR(10) NOT NULL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
	rol ENUM('administrador', 'cajero', 'medico') NULL,
    edad INT NOT NULL,
    fechanac DATE NOT NULL
);

 -- PERSONA, USUARIO Y CONTRASEÑA
INSERT INTO Persona (cedula, nombre, apellido, rol, edad, fechanac)
VALUES 
('0987654321', 'María', 'González', 'administrador', 28, '1996-09-22');
INSERT INTO Usuario (cedula, contrasena)
VALUES 
('0987654321', 'password1');

INSERT INTO Persona (cedula, nombre, apellido, rol, edad, fechanac)
VALUES 
('0701654584', 'Alex', 'Lopez', 'medico', 30, '1993-08-12');
INSERT INTO Usuario (cedula, contrasena)
VALUES 
('0701654584', 'password2');

INSERT INTO Persona (cedula, nombre, apellido, rol, edad, fechanac)
VALUES 
('0950874968', 'Jesus', 'Miranda', 'cajero', 22, '2001-05-12');
INSERT INTO Usuario (cedula, contrasena)
VALUES 
('0950874968', 'jesus');

SELECT * FROM Persona ;
SELECT * FROM Medico ;

-- Tabla de pacientes
CREATE TABLE Paciente (
    id_paciente INT NOT NULL AUTO_INCREMENT,
    cedula VARCHAR(10) NOT NULL,
    direccion VARCHAR(100) NOT NULL,
    correo VARCHAR(100) NOT NULL,
    celular VARCHAR(10),
    PRIMARY KEY (id_paciente),
    UNIQUE (cedula),
    FOREIGN KEY (cedula) REFERENCES Persona(cedula)
);




-- Tabla Especialidad
CREATE TABLE Especialidad (
    id_especialidad INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    numero_consultorio INT NOT NULL,
	valor_especialidad DOUBLE NOT NULL,
    PRIMARY KEY (id_especialidad)
);
                       INSERT INTO Especialidad (nombre, numero_consultorio, valor_especialidad) VALUES
('Cardiología', 1, 18.00),
('Neurología', 2, 25.00),
('Traumatología', 3, 18.00),
('Dermatología', 4, 16.00),
('Oftalmología', 5, 25.00),
('Otorrinolaringología', 6, 16.00),
('General', 7, 15.00),
('Pediatria', 8, 13.00);



-- Tabla de medicos
CREATE TABLE Medico (
    id_medico INT NOT NULL AUTO_INCREMENT,
    cedula VARCHAR(10) NOT NULL,
    especialidad_id INT NOT NULL,
    PRIMARY KEY (id_medico),
    UNIQUE (cedula),
    FOREIGN KEY (cedula) REFERENCES Persona(cedula),
    FOREIGN KEY (especialidad_id) REFERENCES Especialidad(id_especialidad)
);


 
CREATE TABLE factura_consulta_medica (
    nro_factura INT PRIMARY KEY,
    paciente_ci CHAR(10) NOT NULL,
    fecha DATE NOT NULL,
    descripcion_consulta TEXT NOT NULL,
    especialidad_id INT NOT NULL,
    medico_id INT NOT NULL,
    total DOUBLE NOT NULL,
    FOREIGN KEY (paciente_ci) REFERENCES Paciente(cedula),
    FOREIGN KEY (especialidad_id) REFERENCES Especialidad(id_especialidad),
    FOREIGN KEY (medico_id) REFERENCES Medico(id_medico)
);

-- Tabla Farmaco
CREATE TABLE Farmaco (
    id_farmaco INT NOT NULL AUTO_INCREMENT,
    nombre_medicamento VARCHAR(100) NOT NULL,
    cantidad INT NOT NULL,
    presentacion VARCHAR(100) NOT NULL,
    PRIMARY KEY (id_farmaco)
);
ALTER TABLE Farmaco ADD COLUMN descripcion TEXT;
ALTER TABLE Farmaco MODIFY COLUMN cantidad VARCHAR(50) NOT NULL;

-- Tabla AtencionMedica
CREATE TABLE atencion_medica (
    id_atencion INT NOT NULL AUTO_INCREMENT,
    paciente_ci VARCHAR(10) NOT NULL,
    medico_ci VARCHAR(10) NOT NULL,
    fecha_atencion DATE NOT NULL,
    temp DOUBLE NOT NULL,
    pulso INT NOT NULL,
    diagnostico TEXT NOT NULL,
    PRIMARY KEY (id_atencion),
    FOREIGN KEY (paciente_ci) REFERENCES Paciente(cedula),
    FOREIGN KEY (medico_ci) REFERENCES Medico(cedula)
);
SELECT * FROM receta;

CREATE TABLE receta (
    id_receta INT NOT NULL AUTO_INCREMENT,
    id_atencion INT NOT NULL,
    farmaco_id INT,
    medicamento VARCHAR(255),
    unidades INT NOT NULL,
    dosis VARCHAR(200) NOT NULL,
    dias INT NOT NULL,
    PRIMARY KEY (id_receta),
    FOREIGN KEY (id_atencion) REFERENCES atencion_medica(id_atencion),
    FOREIGN KEY (farmaco_id) REFERENCES Farmaco(id_farmaco),
    CHECK (farmaco_id IS NOT NULL OR medicamento IS NOT NULL)
);





