<template>
  <button type="button" class="btn btn-outline-success" @click="formWritting()"> {{(edit)?"Modify":"Add"}} </button>
  <div class="modalperso" v-show="showForm" @click="showForm=false">
  <form class="modal-content" @click="formControl">
    <div class="form-group">
      <label for="name">Name</label>
      <div class="d-flex justify-content-center">
      <input type="text" v-model="name" class="form-control" id="name"  placeholder="Enter name">
      </div>
    </div>
    <div class="form-group">
      <label for="discovery">Discovery</label>
      <input type="text" v-model="discovery" class="form-control" id="discovery" placeholder="Enter Discovery">
    </div>
    <div class="form-group">
      <label for="type">Type</label>
      <input type="text" v-model="type" class="form-control" id="type" placeholder="Enter Type">
    </div>
    <div class="">
    <button type="button" @click="postPlanete()" class="btn btn-primary"> Validate </button>
    </div>
  </form>
  </div>
</template>

<script>
import PlaneteService from "../services/PlaneteService";

export default {
  name: "Form",
  props: {edit: {type: Boolean, default: false}, planete: {type: Object}},
  data() {
    return {
      name: "",
      discovery: "",
      type: "",
      showForm: false,
      nom: "Ajouter"
    }
  },
  methods: {
    postPlanete() {
      if (this.edit) {
        PlaneteService.updatePlanete(this.name, this.discovery, this.type, this.planete.id).then(() => {
          this.$emit("POST")
          this.showForm = false;
        })
      } else {
        PlaneteService.postPlanete(this.name, this.discovery, this.type).then(() => {
          this.$emit("POST")
          this.showForm = false;
        })
      }
    },
    formControl(e) {
      e.stopPropagation();
    },
    formWritting() {
      if (this.edit) {
        this.name = this.planete.name;
        this.discovery = this.planete.discovery;
        this.type = this.planete.type;
      }
      this.showForm = true;
    }
  },
}
</script>

<style scoped>
/* The Modal (background) */
.modalperso {
  position: fixed; /* Stay in place */
  z-index: 1; /* Sit on top */
  left: 0;
  top: 0;
  width: 100%; /* Full width */
  height: 100%; /* Full height */
  overflow: auto; /* Enable scroll if needed */
  background-color: rgb(0,0,0); /* Fallback color */
  background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
}

/* Modal Content/Box */
.modal-content {
  background-color: #fefefe;
  margin: 15% auto; /* 15% from the top and centered */
  padding: 20px;
  border: 1px solid #888;
  width: 50%; /* Could be more or less, depending on screen size */
}

/* The Close Button */
.close {
  color: #aaa;
  float: right;
  font-size: 28px;
  font-weight: bold;
}

.close:hover,
.close:focus {
  color: black;
  text-decoration: none;
  cursor: pointer;
}

</style>