﻿//------------------------------------------------------------------------------
// <auto-generated>
//     Este código fue generado por una herramienta.
//
//     Los cambios en este archivo podrían causar un comportamiento incorrecto y se perderán si
//     se vuelve a generar el código.
// </auto-generated>
//------------------------------------------------------------------------------

namespace LoginServicioReferencia
{
    
    
    [System.CodeDom.Compiler.GeneratedCodeAttribute("Microsoft.Tools.ServiceModel.Svcutil", "2.2.0-preview1.23462.5")]
    [System.ServiceModel.ServiceContractAttribute(ConfigurationName="LoginServicioReferencia.ILoginServicio")]
    public interface ILoginServicio
    {
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/ILoginServicio/Login", ReplyAction="http://tempuri.org/ILoginServicio/LoginResponse")]
        LoginServicioReferencia.LoginResponse Login(LoginServicioReferencia.LoginRequest request);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/ILoginServicio/Login", ReplyAction="http://tempuri.org/ILoginServicio/LoginResponse")]
        System.Threading.Tasks.Task<LoginServicioReferencia.LoginResponse> LoginAsync(LoginServicioReferencia.LoginRequest request);
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("Microsoft.Tools.ServiceModel.Svcutil", "2.2.0-preview1.23462.5")]
    [System.ServiceModel.MessageContractAttribute(WrapperName="Login", WrapperNamespace="http://tempuri.org/", IsWrapped=true)]
    public partial class LoginRequest
    {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Namespace="http://tempuri.org/", Order=0)]
        public string username;
        
        [System.ServiceModel.MessageBodyMemberAttribute(Namespace="http://tempuri.org/", Order=1)]
        public string password;
        
        public LoginRequest()
        {
        }
        
        public LoginRequest(string username, string password)
        {
            this.username = username;
            this.password = password;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("Microsoft.Tools.ServiceModel.Svcutil", "2.2.0-preview1.23462.5")]
    [System.ServiceModel.MessageContractAttribute(WrapperName="LoginResponse", WrapperNamespace="http://tempuri.org/", IsWrapped=true)]
    public partial class LoginResponse
    {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Namespace="http://tempuri.org/", Order=0)]
        public bool LoginResult;
        
        public LoginResponse()
        {
        }
        
        public LoginResponse(bool LoginResult)
        {
            this.LoginResult = LoginResult;
        }
    }
    
    [System.CodeDom.Compiler.GeneratedCodeAttribute("Microsoft.Tools.ServiceModel.Svcutil", "2.2.0-preview1.23462.5")]
    public interface ILoginServicioChannel : LoginServicioReferencia.ILoginServicio, System.ServiceModel.IClientChannel
    {
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("Microsoft.Tools.ServiceModel.Svcutil", "2.2.0-preview1.23462.5")]
    public partial class LoginServicioClient : System.ServiceModel.ClientBase<LoginServicioReferencia.ILoginServicio>, LoginServicioReferencia.ILoginServicio
    {
        
        /// <summary>
        /// Implemente este método parcial para configurar el punto de conexión de servicio.
        /// </summary>
        /// <param name="serviceEndpoint">El punto de conexión para configurar</param>
        /// <param name="clientCredentials">Credenciales de cliente</param>
        static partial void ConfigureEndpoint(System.ServiceModel.Description.ServiceEndpoint serviceEndpoint, System.ServiceModel.Description.ClientCredentials clientCredentials);
        
        public LoginServicioClient() : 
                base(LoginServicioClient.GetDefaultBinding(), LoginServicioClient.GetDefaultEndpointAddress())
        {
            this.Endpoint.Name = EndpointConfiguration.BasicHttpBinding_ILoginServicio.ToString();
            ConfigureEndpoint(this.Endpoint, this.ClientCredentials);
        }
        
        public LoginServicioClient(EndpointConfiguration endpointConfiguration) : 
                base(LoginServicioClient.GetBindingForEndpoint(endpointConfiguration), LoginServicioClient.GetEndpointAddress(endpointConfiguration))
        {
            this.Endpoint.Name = endpointConfiguration.ToString();
            ConfigureEndpoint(this.Endpoint, this.ClientCredentials);
        }
        
        public LoginServicioClient(EndpointConfiguration endpointConfiguration, string remoteAddress) : 
                base(LoginServicioClient.GetBindingForEndpoint(endpointConfiguration), new System.ServiceModel.EndpointAddress(remoteAddress))
        {
            this.Endpoint.Name = endpointConfiguration.ToString();
            ConfigureEndpoint(this.Endpoint, this.ClientCredentials);
        }
        
        public LoginServicioClient(EndpointConfiguration endpointConfiguration, System.ServiceModel.EndpointAddress remoteAddress) : 
                base(LoginServicioClient.GetBindingForEndpoint(endpointConfiguration), remoteAddress)
        {
            this.Endpoint.Name = endpointConfiguration.ToString();
            ConfigureEndpoint(this.Endpoint, this.ClientCredentials);
        }
        
        public LoginServicioClient(System.ServiceModel.Channels.Binding binding, System.ServiceModel.EndpointAddress remoteAddress) : 
                base(binding, remoteAddress)
        {
        }
        
        public LoginServicioReferencia.LoginResponse Login(LoginServicioReferencia.LoginRequest request)
        {
            return base.Channel.Login(request);
        }
        
        public System.Threading.Tasks.Task<LoginServicioReferencia.LoginResponse> LoginAsync(LoginServicioReferencia.LoginRequest request)
        {
            return base.Channel.LoginAsync(request);
        }
        
        public virtual System.Threading.Tasks.Task OpenAsync()
        {
            return System.Threading.Tasks.Task.Factory.FromAsync(((System.ServiceModel.ICommunicationObject)(this)).BeginOpen(null, null), new System.Action<System.IAsyncResult>(((System.ServiceModel.ICommunicationObject)(this)).EndOpen));
        }
        
        private static System.ServiceModel.Channels.Binding GetBindingForEndpoint(EndpointConfiguration endpointConfiguration)
        {
            if ((endpointConfiguration == EndpointConfiguration.BasicHttpBinding_ILoginServicio))
            {
                System.ServiceModel.BasicHttpBinding result = new System.ServiceModel.BasicHttpBinding();
                result.MaxBufferSize = int.MaxValue;
                result.ReaderQuotas = System.Xml.XmlDictionaryReaderQuotas.Max;
                result.MaxReceivedMessageSize = int.MaxValue;
                result.AllowCookies = true;
                return result;
            }
            throw new System.InvalidOperationException(string.Format("No se pudo encontrar un punto de conexión con el nombre \"{0}\".", endpointConfiguration));
        }
        
        private static System.ServiceModel.EndpointAddress GetEndpointAddress(EndpointConfiguration endpointConfiguration)
        {
            if ((endpointConfiguration == EndpointConfiguration.BasicHttpBinding_ILoginServicio))
            {
                return new System.ServiceModel.EndpointAddress("http://localhost:42436/ec.edu.monster.servicios/LoginServicio.svc");
            }
            throw new System.InvalidOperationException(string.Format("No se pudo encontrar un punto de conexión con el nombre \"{0}\".", endpointConfiguration));
        }
        
        private static System.ServiceModel.Channels.Binding GetDefaultBinding()
        {
            return LoginServicioClient.GetBindingForEndpoint(EndpointConfiguration.BasicHttpBinding_ILoginServicio);
        }
        
        private static System.ServiceModel.EndpointAddress GetDefaultEndpointAddress()
        {
            return LoginServicioClient.GetEndpointAddress(EndpointConfiguration.BasicHttpBinding_ILoginServicio);
        }
        
        public enum EndpointConfiguration
        {
            
            BasicHttpBinding_ILoginServicio,
        }
    }
}