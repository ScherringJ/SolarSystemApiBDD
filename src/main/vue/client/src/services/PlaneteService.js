import axios from "axios";

const PLANETE_API_URL = 'http://localhost:8080/Planete'

class PlaneteService {

    getPlaneteAll() {
        return axios.get(PLANETE_API_URL);
    }

    deletePlanete(id) {
        return axios.delete(PLANETE_API_URL + "/" + id)
    }
}

export default new PlaneteService()