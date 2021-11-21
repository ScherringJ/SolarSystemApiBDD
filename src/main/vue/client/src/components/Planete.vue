<template>
  <div class="container">
    <h1 class="text-center"> Planete List</h1>
    <table class="table table-striped">
      <thead>
        <th> Planete ID </th>
        <th> Planete name </th>
        <th> Planete Discovery </th>
        <th> Planete type </th>
      </thead>
      <tr v-for="planete in planetes" v-bind:key = "planete.id">
          <td> {{planete.id}}</td>
          <td> {{planete.name}}</td>
          <td> {{planete.discovery}}</td>
          <td> {{planete.type}}</td>
          <td>
            <button type="button" @click="deletePlanete(planete.id)"  class="btn btn-outline-danger">Delete</button>
          </td>
      </tr>
    </table>
  </div>
</template>

<script>
import PlaneteService from "../services/PlaneteService";

export default {
  name: "Planete",
  data() {
    return {
      planetes : []
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
       });
    }
  },
  created() {
    this.getPlaneteAll()
  },
}
</script>



<style scoped>

</style>