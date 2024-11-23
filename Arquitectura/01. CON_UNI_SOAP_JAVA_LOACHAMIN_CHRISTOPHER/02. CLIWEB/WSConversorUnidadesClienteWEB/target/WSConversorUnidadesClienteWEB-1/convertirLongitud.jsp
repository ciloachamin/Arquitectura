<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Conversión de Longitud</title>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/tailwindcss/2.2.19/tailwind.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet">
    <style>
        body {
            background: linear-gradient(135deg, #EFF6FF 0%, #DBEAFE 100%);
            min-height: 100vh;
        }
        .converter-card {
            background: rgba(255, 255, 255, 0.95);
            box-shadow: 0 8px 32px rgba(0, 0, 0, 0.1);
            backdrop-filter: blur(10px);
        }
        select, input[type="number"] {
            background-image: linear-gradient(to bottom, #ffffff 0%, #f9fafb 100%);
        }
        .input-group {
            position: relative;
        }
        .input-group i {
            position: absolute;
            left: 1rem;
            top: 50%;
            transform: translateY(-50%);
            color: #6B7280;
        }
        select:focus, input:focus {
            border-color: #3B82F6;
            box-shadow: 0 0 0 3px rgba(59, 130, 246, 0.1);
        }
    </style>
</head>
<body class="flex items-center justify-center p-6">
    <div class="converter-card w-full max-w-md p-8 rounded-2xl">
        <div class="text-center mb-8">
            <i class="fas fa-ruler text-4xl text-blue-600 mb-4"></i>
            <h1 class="text-2xl font-bold text-gray-800">Conversor de Longitud</h1>
            <p class="text-gray-600 mt-2">Convierte fácilmente entre diferentes unidades de medida</p>
        </div>

        <form action="convertirLongitud" method="post" class="space-y-6">
            <!-- Valor Input -->
            <div class="space-y-2">
                <label for="valor" class="block text-sm font-medium text-gray-700">
                    Ingrese el valor
                </label>
                <div class="input-group">
                    <i class="fas fa-calculator"></i>
                    <input type="number" 
                           id="valor" 
                           name="valor" 
                           min="0" 
                           required 
                           class="pl-10 block w-full rounded-md border-gray-300 shadow-sm focus:outline-none py-2 px-3"
                           placeholder="0.00">
                </div>
            </div>

            <!-- Unidad de Origen -->
            <div class="space-y-2">
                <label for="unidadOrigen" class="block text-sm font-medium text-gray-700">
                    Unidad de Origen
                </label>
                <select id="unidadOrigen" 
                        name="unidadOrigen" 
                        required
                        class="block w-full rounded-md border-gray-300 shadow-sm focus:outline-none py-2 px-3">
                    <option value="">Seleccione unidad</option>
                    <option value="metro">Metros</option>
                    <option value="kilometro">Kilómetros</option>
                    <option value="centimetro">Centímetros</option>
                </select>
            </div>

            <!-- Icono de intercambio -->
            <div class="flex justify-center">
                <button type="button" class="p-2 text-blue-600 hover:text-blue-800 transition-colors">
                    <i class="fas fa-exchange-alt text-xl"></i>
                </button>
            </div>

            <!-- Unidad de Destino -->
            <div class="space-y-2">
                <label for="unidadDestino" class="block text-sm font-medium text-gray-700">
                    Unidad de Destino
                </label>
                <select id="unidadDestino" 
                        name="unidadDestino" 
                        required
                        class="block w-full rounded-md border-gray-300 shadow-sm focus:outline-none py-2 px-3">
                    <option value="">Seleccione unidad</option>
                    <option value="metro">Metros</option>
                    <option value="kilometro">Kilómetros</option>
                    <option value="centimetro">Centímetros</option>
                </select>
            </div>

            <!-- Botón de Conversión -->
            <button type="submit" 
                    class="w-full bg-blue-600 text-white py-2 px-4 rounded-md hover:bg-blue-700 focus:outline-none focus:ring-2 focus:ring-blue-500 focus:ring-offset-2 transition-colors duration-200 flex items-center justify-center space-x-2">
                <i class="fas fa-sync-alt"></i>
                <span>Convertir</span>
            </button>
        </form>

        <!-- Resultado (si existe) -->
        <c:if test="${not empty resultado}">
            <div class="mt-6 p-4 bg-green-50 rounded-md border border-green-200">
                <div class="flex">
                    <div class="flex-shrink-0">
                        <i class="fas fa-check-circle text-green-400"></i>
                    </div>
                    <div class="ml-3">
                        <p class="text-sm text-green-700">
                            Resultado: ${resultado}
                        </p>
                    </div>
                </div>
            </div>
        </c:if>
    </div>

    <script>
        // Script para intercambiar unidades
        document.querySelector('.fa-exchange-alt').parentElement.addEventListener('click', function() {
            const origen = document.getElementById('unidadOrigen');
            const destino = document.getElementById('unidadDestino');
            const temp = origen.value;
            origen.value = destino.value;
            destino.value = temp;
        });
    </script>
</body>
</html>