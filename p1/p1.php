<!Doctype html>
<html>
	<head>
		<title>Procesado de formulario</title>
		<link rel="stylesheet" type="text/css" href="p1.css">
	</head>
	<body>
<?php


	if ($_SERVER['REQUEST_METHOD']== 'POST') {
		$metodo = $_POST;
	}
	else {
		$metodo = $_GET;
	}


?>
	<h1>Formulario academico</h1>
	<fieldset  class="fields_php">
		<h2>Datos formulario</h2>
			<table class="tabla_php">
					<tr>
						<td class="info">Titulo</td>
						<td class="tabla_phpRespuestas"><?php $titulo = $metodo['titulo']; echo $titulo; ?></td>
					</tr>
					<tr>
						<td class="info">Director</td>
						<td class="tabla_phpRespuestas"><?php $director = $metodo['director']; echo $director; ?></td>
					</tr>
					<tr>
						<td class="info">Productora</td>
						<td class="tabla_phpRespuestas"><?php $productora = $metodo['productora']; echo $productora; ?></td>
					</tr>
					<tr>
						<td class="info">Telefono Productora</td>
						<td class="tabla_phpRespuestas"><?php $telefono = $metodo['telefono']; echo $telefono; ?></td>
					</tr>
					<tr>
						<td class="info">Genero</td>
						<td class="tabla_phpRespuestas"><?php if (empty($metodo['genero'])) {
							echo " ";
						} else{
								echo  $metodo['genero'];
						} ?></td>
					</tr>
					<tr>
						<td class="info">Clasificacion</td>
						<td class="tabla_phpRespuestas"><?php $clasificacion = $metodo['clasificacion']; echo $clasificacion; ?></td>
					</tr>
					<tr>
						<td class="info">Idiomas disponibles</td>
						<td class="tabla_phpRespuestas"><?php if(empty($metodo['ingles'])) echo ""; else echo 'Ingles';
						if (empty($metodo['vose'])) echo ""; else echo ', VOSE';
						if (empty($metodo['castellano'])) echo ""; else echo ', castellano';
						if (empty($metodo['latino'])) echo ""; else echo ', latino';
						 ?></td>
					</tr>
					<tr>
						<td id="titulo_fichero" class="info" colspan="2">Fichero</td>
					</tr>
					<tr>
						<td class="info">Nombre</td>
						<td class="tabla_phpRespuestas"><?php if(!empty($_FILES['imagen'])) echo $_FILES['imagen']['name'] ?></td>
					</tr>
					<tr>
						<td class="info">Tamano</td>
						<td class="tabla_phpRespuestas"><?php if(!empty($_FILES['imagen'])) {echo $_FILES['imagen']['size']; echo ' bytes';}  ?></td>
					</tr>
					<tr>
						<td class="info">Extension</td>
						<td class="tabla_phpRespuestas"><?php if(!empty($_FILES['imagen'])) echo $_FILES['imagen']['type'] ?></td>
					</tr>
			</table>
		</fieldset>
		<fieldset class="fields_php">
			<h2>Datos server</h2>
			<table class="tabla_php">
				<tbody>
					<tr>
						<td class="info">Metodo de Envio</td>
						<td class="tabla_phpRespuestas"><?php if($metodo == $_POST) echo 'Post'; else echo 'Get'; ?></td>
					</tr>
					<tr>
						<td class="info">Codificacion</td>
						<td class="tabla_phpRespuestas"><?php
											if($_SERVER['REQUEST_METHOD'] == 'GET')
												echo 'x-www-form-urlencoded';
											elseif($metodo['cod']=='x-www-form-urlencoded')
													echo 'x-www-form-urlencoded';
											else
													echo 'multipart/form-data';?></td>
					</tr>
					<tr>
						<td class="info">URL</td>
						<td class="tabla_phpRespuestas"><?php echo $_SERVER["SCRIPT_NAME"] ?></td>
					</tr>
					<tr>
						<td class="info">Hora de envio</td>
						<td class="tabla_phpRespuestas"><?php 	echo $metodo['hora'];?></td>
					</tr>
					<tr>
						<td class="info">Version navegador</td>
						<td class="tabla_phpRespuestas"><?php echo $metodo['navegador'];?></td>
					</tr>
					<tr>
						<td class="info">Direccion IP cliente</td>
						<td class="tabla_phpRespuestas"><?php echo $_SERVER['REMOTE_ADDR']; ?></td>
					</tr>
					<tr>
						<td class="info">Direccion IP servidor</td>
						<td class="tabla_phpRespuestas"><?php echo $_SERVER['SERVER_ADDR']; ?></td>
					</tr>
				</tbody>
			</table>

	</fieldset>
</html>
