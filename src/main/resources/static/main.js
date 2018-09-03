const url = '/api/1/tracks/'

const Tracks = {
    data() {
        return {
            tracks: null
        }
    },
    mounted() {
        axios
            .get('/api/1/tracks')
            .then(response => (this.tracks = response.data));
    },
    methods: {
        addTrack: function () {
            router.push({path: '/new-track'})
        }
    },
    template: `
        <ol>
            <button v-on:click="addTrack">Add car</button>
            <li v-for="track in tracks">
            {{ track.name }}
            <router-link :to="'/tracks/'+track.id">Edit</router-link>
            </li>
        </ol>
    `
}
const TrackView = {
    props: {
        id: String
    },
    data() {
        return {
            model: {length: {}, cars: []},
            isNew: true
        }
    },
    created() {
        if (this.id) {
            axios
                .get(url + this.id)
                .then(response => (this.model = response.data));
            this.isNew = false
        }
    },
    methods: {
        addCar: function () {
            this.model.cars.push({'max-speed': {}})
        },
        deleteCar: function (car) {
            const i = this.model.cars.indexOf(car)
            this.model.cars.splice(i, 1)
        },
        save: function () {
            var req
            if (this.isNew)
                req = axios.post(url, this.model)
            else
                req = axios.put(url, this.model)

            req.then(response => {
                    alert("Saved")
                    this.isNew = false
                    router.push({path: '/tracks/'+response.data})
                }
            )
                .catch(e => alert("Failed: " + e))
        }
    },
    template: `
        <div>
            <router-link to="/tracks">List</router-link>
            <ul>
                <li><input v-model="model.id" placeholder="Id"></li>
                <li><input v-model="model.name" placeholder="Name"></li>
                <li><input v-model="model.description" placeholder="Description"></li>
                <li>
                    <input v-model="model.length.value" placeholder="length">
                    <select v-model="model.length.unit">
                        <option selected>km</option>
                    </select>
                </li>
                <li>Cars
                    <ul>
                        <li v-for="car in model.cars">
                            <ul>
                                <li><input v-model="car.id" placeholder="Id"></li>
                                <li><input v-model="car.code" placeholder="Code"></li>
                                <li>Transmission:
                                    <select v-model="car.transmission">
                                        <option>automatic</option>
                                        <option>manual</option>
                                    </select>
                                </li>
                                <li>AI:
                                    <select v-model="car.ai">
                                        <option>disabled</option>
                                        <option>enabled</option>
                                    </select>
                                </li>
                                <li>
                                    <input v-model="car['max-speed'].value" placeholder="Speed">
                                    <select v-model="car['max-speed'].unit">
                                        <option selected>mps</option>
                                    </select>
                                </li>
                                <button v-on:click="deleteCar(car)">Remove car</button>
                            </ul>
                        </li>
                        <button v-on:click="addCar">Add car</button>
                    </ul>
                </li>
            </ul>       
            <button v-on:click="save">Save</button>    
        </div>
`
}

const routes = [
    {path: '/', redirect: '/tracks'},
    {path: '/tracks', component: Tracks},
    {path: '/tracks/:id', component: TrackView, props: true},
    {path: '/new-track', name: 'newTrack', component: TrackView}
]

const router = new VueRouter({
    routes // short for `routes: routes`
})

const app = new Vue({
    router
}).$mount('#app')