import axios from "axios";

const PLANETE_API_URL = 'http://localhost:8080/Planete'

class PlaneteService {

    getPlaneteAll() {
        return axios.get(PLANETE_API_URL);
    }

    deletePlanete(id) {
        return axios.delete(PLANETE_API_URL + "/" + id)
    }

    getPlanete(id) {
        return axios.get(PLANETE_API_URL + "/" + id)
    }

    postPlanete(name, discovery, type) {
        let planete = {name: name, discovery:discovery, type:type};
        return axios.post( PLANETE_API_URL, planete);
    }

    updatePlanete(name, discovery, type, id) {
        let planete = {name: name, discovery:discovery, type:type};
        return axios.put( PLANETE_API_URL + "/" + id, planete);
    }
}

export default new PlaneteService()