<template>
  <div class="container">
    <h1 class="text-center"> Planete List </h1>
    <select v-model="selected">
      <option v-for="id in this.option" :key = "id" :value="id">
        {{ id }}
      </option>
    </select>
    <button type="button" @click="getPlanete(selected)" class="btn btn-outline-info">Get</button>
    <table class="table table-striped">
      <thead>
        <th> Planete ID </th>
        <th> Planete Name </th>
        <th> Planete discovery </th>
        <th> Planete type </th>
      </thead>
      <tr v-for="planete in planetes" v-bind:key = "planete.id">
          <td> {{planete.id}}</td>
          <td> {{planete.name}}</td>
          <td> {{planete.discovery}}</td>
          <td> {{planete.type}}</td>
          <td>
            <Form edit :planete="planete" @POST="onPost"></Form>
            <button type="button" @click="deletePlanete(planete.id)"  class="btn btn-outline-danger">Delete</button>
          </td>
      </tr>
    </table>
  </div>
  <Form @POST="onPost"></Form>
</template>

<script>
import PlaneteService from "../services/PlaneteService";
import Form from "./Form";

export default {
  name: "Planete",
  components: {Form},
  data() {
    return {
      selected: '',
      planetes : [],
      planetess : [],
      showForm : false,
    }

  },
  computed: {
    option() {
      let id = ['All']
      this.planetess.forEach((planete) => {
        id.push(planete.id)
      })
      return id;
    }
  },
  methods: {
    deletePlanete(id) {
      PlaneteService.deletePlanete(id).then(() => {
        this.getPlaneteAll();
      })
    },
    getPlaneteAll() {
       PlaneteService.getPlaneteAll().then((response) => {
          this.planetes = response.data;
          this.planetess = response.data;
       });
    },
    getPlanete(id) {
      if (id === 'All') {
        console.log(id)
        PlaneteService.getPlaneteAll().then((response) => {
          this.planetes = response.data;
        })
      } else {
        console.log(id)
        PlaneteService.getPlanete(id).then((response) => {
          this.planetes = [response.data];
        })
      }
    },
    onPost() {
      this.getPlaneteAll();
    }
  },
  created() {
    this.getPlaneteAll()
  },
}
</script>



<style scoped>

</style>