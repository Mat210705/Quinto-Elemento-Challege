const app = Vue.createApp({
    data() {
        return {
            alumnos:[],
            profesores:[],
            cursos:[],
            id:0,
            nombre:"",
            apellido:"",
            email:"",
            password:0,
            roleName:"",
            turno:"",
            curso:"",


        }
    },
    created() {
        this.loadAlumnos();
      
    },
    methods: {
        // *Alumno_________________________________________________________________
         loadAlumnos(){
             axios.get('/api/alumnos')
             .then(response => {
                console.log(response);
                this.alumnos = response.data;                                  
             }) 
         },
        editarAlumno(){
            axios.put('/api/editar/alumno?id='+this.id,{
                        nombre:`${this.nombre}`,
                        apellido:`${this.apellido}`,
                        email:`${this.email}`,
                        password:`${this.password}`,
                        }
              );
    
        },
        deleteAlumno() {
            axios.delete('/api/eliminar/alumno?id='+this.id)
                .then(() => swal('El alumno a sido eliminado con exito'))
                       
        },
        anotarAlumnoACurso(){
            axios.post('/api/alumno/anotarse/curso',`id=${this.id}&nombre=${this.curso}&turno=${this.turno}`)
                .then(()=>  swal('El alumno a sido anotado a un curso de manera exitosa con exito'))
        },
        
    
        }  
    
})
let consol = app.mount("#app")


