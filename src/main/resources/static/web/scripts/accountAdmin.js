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
        this.loadProfesor();
        this.loadCursos();
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

         crearAlumno(){
            axios.post('/api/crear/alumno',`nombre=${this.nombre}&apellido=${this.apellido}&email=${this.email}&password=${this.password}`)
            .then(response => swal( 'Hola, '+`${this.nombre}`,
            'El Alumno a sido creado con exito se a creado con exito.',
            'success'))
            .then(() => location.reload())
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
        
        // *Profesor_________________________________________________________________
        loadProfesor(){
            axios.get('/api/profesores')
            .then(response => {
               console.log(response);
               this.profesores = response.data;
                                                                       
            }) 
        },
        crearProfesor(){
            axios.post('/api/crear/profesor', `nombre=${this.nombre}&apellido=${this.apellido}&email=${this.email}&password=${this.password}&roleName=${this.roleName}`)
            .then(response => swal( 'Hola, '+`${this.nombre}`,
            'El Profesor a sido creado con exito se a creado con exito.',
            'success'))
            .then(() => location.reload())
        },
        editarProfesor(){
            axios.put('/api/editar/profesor?id='+this.id,{
                        nombre:`${this.nombre}`,
                        apellido:`${this.apellido}`,
                        email:`${this.email}`,
                        password:`${this.password}`,
                        }
              );
    
        },
        deleteProfesor() {
            axios.delete('/api/eliminar/profesor?id='+this.id)
                .then(() => swal('El Profesor a sido eliminado con exito'))
                       
        },
        AsignarACurso(){
            axios.post('/api/profesor/anotarse/curso',`id=${this.id}&nombre=${this.curso}&turno=${this.turno}`)
                .then(()=>  swal('El Profesor a sido anotado a un curso de manera exitosa con exito'))
        },
        // *Cursos_________________________________________________________________
        loadCursos(){
            axios.get('/api/cursos')
            .then(response => {
               console.log(response);
               this.cursos = response.data;
               console.log(response.data)
               console.log(response.data.cursos)                                                        
            }) 
        },
        crearCurso(){
            axios.post('/api/crear/curso', `nombre=${this.curso}&turno=${this.turno}`)
            .then(response => swal( 'Hola, '+`${this.nombre}`,
            'El Curso a sido creado con exito se a creado con exito.',
            'success'))
            .then(() => location.reload())
        },
        editarCurso(){
            axios.put('/api/editar/curso?id='+this.id,{
                        nombre:`${this.nombre}`,
                        turno:`${this.turno}`,
                        }
              );
    
        },
        deleteCurso() {
            axios.delete('/api/eliminar/curso?id='+this.id)
                .then(() => swal('El Curso a sido eliminado con exito'))
                       
        },
        }  
    
})
let consol = app.mount("#app")


