<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/tailwindcss/2.2.19/tailwind.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet">
    <style>
        body {
            background: linear-gradient(135deg, #f6f7fb 0%, #e9edf6 100%);
        }
        .login-card {
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            background: rgba(255, 255, 255, 0.9);
            backdrop-filter: blur(10px);
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
        .input-field {
            transition: all 0.3s ease;
        }
        .input-field:focus {
            border-color: #3B82F6;
            box-shadow: 0 0 0 3px rgba(59, 130, 246, 0.1);
        }
        .error-message {
            display: none;
        }
        .error-message.visible {
            display: block;
        }
    </style>
</head>
<body class="min-h-screen flex items-center justify-center py-12 px-4 sm:px-6 lg:px-8">
    <div class="login-card max-w-md w-full space-y-8 p-8 rounded-xl">
        <!-- Logo o Imagen -->
        <div class="text-center">
            <img src="public/login9.png" alt="Logo" class="mx-auto h-20 w-20 rounded-full shadow-md">
            <h2 class="mt-6 text-3xl font-extrabold text-gray-900">Bienvenido</h2>
            <p class="mt-2 text-sm text-gray-600">Ingresa tus credenciales para continuar</p>
        </div>

        <!-- Formulario -->
        <form class="mt-8 space-y-6" action="login" method="post">
            <div class="rounded-md shadow-sm space-y-4">
                <div class="input-group">
                    <i class="fas fa-user"></i>
                    <input id="username" 
                           name="username" 
                           type="text" 
                           required 
                           class="input-field pl-10 w-full px-3 py-2 border border-gray-300 rounded-md focus:outline-none"
                           placeholder="Usuario">
                </div>

                <div class="input-group">
                    <i class="fas fa-lock"></i>
                    <input id="password" 
                           name="password" 
                           type="password" 
                           required 
                           class="input-field pl-10 w-full px-3 py-2 border border-gray-300 rounded-md focus:outline-none"
                           placeholder="Contraseña">
                </div>
            </div>

            <div class="flex items-center justify-between">
                <div class="flex items-center">
                    <input id="remember-me" 
                           name="remember-me" 
                           type="checkbox"
                           class="h-4 w-4 text-blue-600 focus:ring-blue-500 border-gray-300 rounded">
                    <label for="remember-me" class="ml-2 block text-sm text-gray-900">
                        Recordarme
                    </label>
                </div>

                <div class="text-sm">
                    <a href="#" class="font-medium text-blue-600 hover:text-blue-500">
                        ¿Olvidaste tu contraseña?
                    </a>
                </div>
            </div>

            <div>
                <button type="submit" 
                        class="group relative w-full flex justify-center py-2 px-4 border border-transparent text-sm font-medium rounded-md text-white bg-blue-600 hover:bg-blue-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-blue-500 transition-colors duration-200">
                    <span class="absolute left-0 inset-y-0 flex items-center pl-3">
                        <i class="fas fa-sign-in-alt"></i>
                    </span>
                    Iniciar sesión
                </button>
            </div>
        </form>

        <!-- Mensaje de Error (Solo se muestra si hay error) -->
        <c:if test="${not empty error}">
            <div class="mt-4 bg-red-50 border-l-4 border-red-400 p-4 error-message ${not empty error ? 'visible' : ''}">
                <div class="flex">
                    <div class="flex-shrink-0">
                        <i class="fas fa-exclamation-circle text-red-400"></i>
                    </div>
                    <div class="ml-3">
                        <p class="text-sm text-red-700">${error}</p>
                    </div>
                </div>
            </div>
        </c:if>
    </div>
</body>
</html>