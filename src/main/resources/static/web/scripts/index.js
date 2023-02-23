const app = Vue.createApp({
    data() {
        return {
            alumnos:[],
            profesores:[],
            nombre:"",
            apellido:"",
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

         createUser(){
             axios.post('/api/register',`nombre=${this.nombre}&apellido=${this.apellido}&email=${this.email}&password=${this.password}&roleName=${this.roleName}`)
             .then(response => swal( 'Hola, '+`${this.nombre}`,
             'Su cuenta se a creado con exito.',
             'success'))
             .then(() => {
                axios.post('/api/login', `email=${this.email}&password=${this.password}`,{ headers: {'content-type':'application/x-www-form-urlencoded'}})
                .then(res => window.location.href = ("/web/accounts.html"))
             }) 
         },    
         
         loadData() {
            axios.post('/api/login', `email=${this.email}&password=${this.password}&roleName=${this.roleName}`,{ headers: {'content-type':'application/x-www-form-urlencoded'}})
            .then(response => { 
                if (this.roleName === "alumno") { 
                    window.location.href = ("/web/accountAlumno.html")
                    this.alumnos =  axios.get('/api/alumno?email='+this.email)
                    } else if(this.roleName === "profesor"){
                            window.location.href = ("/web/accountProfesor.html")
                            } else{
                                window.location.href = ("/web/accountAdmin.html")
                                }  
              })
            
            
            .catch(response => swal("Su Usuario y contraseña es Incorrecto","Intente nuevamente"))
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


