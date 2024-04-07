create database BaseDeDatosPrincipal;

create table Usuarios(
	cveUsuario int auto_increment primary key,
    direccionCorreoElectronico varchar(100),
    nombre varchar(50),
    apellidos varchar(50),
    telefono varchar(15),
    contraseña varchar(128)
    );

create table Empleado(
	folioEmpleado int auto_increment primary key,
    nombre varchar(50),
    apellidos varchar(50),
    correoElectronico varchar(100),
    telefono varchar(15),
    oficina varchar(30),
    departamento varchar(30),
    tipoContrato varchar(50),
    estado varchar(120),
    ciudad varchar(120),
    calle varchar(120),
    codigoPostal int,
    fechaDeNacimiento date,
    puestoDeTrabajo varchar(30),
    genero varchar(1),
    sueldo int,
    curp varchar(18),
    rfc varchar(13)
    );
    
create table TurnosDeTrabajo(
	cveTurno int auto_increment primary key,
    turno varchar(10),
    horaES varchar(10)
    );
    
create table EmpleadoTurno(
	folioEmpleado int,
    cveTurno int,
    foreign key (folioEmpleado) references Empleado(folioEmpleado),
    foreign key (cveTurno) references TurnosDeTrabajo(cveTurno)
    );
    
create table Terminal(
	cveLugar int auto_increment primary key,
    nombreLugar varchar(40)
    );

create table Rutas(
	cveRuta int auto_increment primary key,
    distancia varchar(10),
    puntoOrigen int,
    puntoDestino int,
    duracionEstimada varchar(10),
    paradasIntermedias varchar(1000),
    foreign key (puntoOrigen) references Terminal(cveLugar),
    foreign key (puntoDestino) references Terminal(cveLugar)
    );

create table HorariosSalida(
	cveHora int auto_increment primary key,
    hora varchar(10)
    );

create table Facturas(
	numeroFactura int auto_increment primary key,
    fechaEmision date,
    cveUsuario int,
    importeTotal decimal,
    estadoDeFactura varchar(20),
    foreign key (cveUsuario) references Usuarios(cveUsuario)
    );

create table Pagos(
	numeroFactura int,
    fechaDePago date,
    metodoDePago varchar(25),
    importePagado int,
    estadoDePago varchar(20),
    foreign key (numeroFactura) references Facturas(numeroFactura)
    );

create table MediosDeTransporte(
	cveMDT int auto_increment primary key,
    tipoDeUnidad varchar(50),
    modelo varchar(50),
    marca varchar(50),
    placas varchar(10),
    capacidadDePersonas int,
    fichaTecnica varchar(200),
    capacidadDeCarga int,
    extras varchar(200)
    );

create table HistorialDeMantenimiento(
	cveHMV int auto_increment primary key,
    cveMDT int,
    fecha date,
    reparaciones varchar(300),
    costosAsociados varchar(30),
    foreign key (cveMDT) references MediosDeTransporte(cveMDT)
    );

create table Descuentos(
	cveDescuento int auto_increment primary key,
    tipoDescuento varchar(50),
    porcentajeDescuento int
    );

create table Costo(
	cveCosto int auto_increment primary key,
    cveMDT int,
    costo int,
    extras varchar(60),
    costoExtras int,
    cveDescuento int,
    total int,
    foreign key (cveMDT) references MediosDeTransporte(cveMDT),
    foreign key (cveDescuento) references Descuentos(cveDescuento)
    );
    
create table Reservaciones(
	cveReservacion int auto_increment primary key,
    cveMDT int,
    numeroAsiento int,
    cveHora int,
    cveLugar int,
    cveCosto int,
    fecha date,
    cveRuta int,
    folioEmpleado int,
    numeroFactura int,
    cveUsuario int,
    foreign key (cveMDT) references MediosDeTransporte(cveMDT),
    foreign key (cveHora) references HorariosSalida(cveHora),
    foreign key (cveLugar) references Terminal(cveLugar),
    foreign key (cveCosto) references Costo(cveCosto),
    foreign key (cveRuta) references Rutas(cveRuta),
    foreign key (folioEmpleado) references Empleado(folioEmpleado),
    foreign key (numeroFactura) references Factura(numeroFactura),
    foreign key (cveUsuario) references Usuarios(cveUsuario)
    );
