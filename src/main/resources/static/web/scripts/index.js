const app = Vue.createApp({
    data() {
        return {
            nombre: "",
            apellido: "",
            email:"",
            password:"",
            roleName:"",
            showModalIniciarSesion:true,
            showModalRegistro: false,


        }
    },
    created() {
        
    },
    methods: {
        
     
         crearUsuario(e){
             e.preventDefault()            
             axios.post('/api/register', `nombre=${this.nombre}&apellido=${this.apellido}&email=${this.email}&password=${this.password}&roleName=${this.roleName}`, { headers: {'content-type':'application/x-www-form-urlencoded'}})             
             .then(res => window.location.href = ("/web/accounts.html"))
           
         },         
         loadData() {
            axios.post('/api/login', `email=${this.email}&password=${this.password}`,{ headers: {'content-type':'application/x-www-form-urlencoded'}})
            .then(res => console.log(res))
            .then(res => window.location.href = ("/web/accounts.html"))
            .catch(res => swal("Su Usuario y contraseña es Incorrecto","Intente nuevamente"))
         },
        
         registroCliente(e){
            console.log(e.target)
            this.showModalRegistro = true;
            this.showModalIniciarSesion = false;            
        },
        inicioCliente(e){
            console.log(e.target)
            this.showModalRegistro = false;
            this.showModalIniciarSesion = true;            
        },





        }  
    
})
let consol = app.mount("#app")


    