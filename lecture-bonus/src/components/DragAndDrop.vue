<template>
  <div class="center-panel">
    <h1>Drag and Drop example</h1>
    <div class="row">
      <div
        class="column1"
        @drop="onDrop($event, 1)"
        @dragover.prevent
        @dragenter.prevent
      >
      <div class="inner-row">
        <div
          class="card"
          v-for="item in listOne"
          :key="item.id"
          draggable
          @dragstart="startDrag($event, item)"
        >
          <img v-bind:src="item.avatar" />
          <div class="container">
            <h4>
              <b>{{ item.name }}</b>
            </h4>
            <p>{{ item.occupation }}</p>
          </div>
        </div>
        </div>
      </div>
      <div
        class="column2"
        @drop="onDrop($event, 2)"
        @dragover.prevent
        @dragenter.prevent
      > 
      <div class="inner-row">
        <div
          class="card"
          v-for="item in listTwo"
          :key="item.id"
          draggable
          @dragstart="startDrag($event, item)"
        >
          <img v-bind:src="item.avatar" />
          <div class="container">
            <h4>
              <b>{{ item.name }}</b>
            </h4>
            <p>{{ item.occupation }}</p>
          </div>
        </div>
        </div>
      </div>
    </div>

  </div>
</template>

<script>


export default {
  name: "drag-and-drop",
  data() {
    return {
      items: [
        {
          id: 0,
          name: "John Doe",
          occupation: "Architect",
          avatar: require("../assets/mystery.png"),
          list: 1,
        },
        {
          id: 1,
          name: "John Deere",
          occupation: "Farmer",
          avatar: require("../assets/mystery.png"),
          list: 2,
        },
      ],
      showModal: false,
    };
  },
  computed: {
    listOne() {
      console.log("inside listOne");
      return this.items.filter((item) => item.list === 1);
    },
    listTwo() {
      console.log("inside listOne");
      return this.items.filter((item) => item.list === 2);
    },
  },
  methods: {
    startDrag(evt, item) {
      console.log("inside start drag" + item.name);
      evt.dataTransfer.dropEffect = "move";
      evt.dataTransfer.effectAllowed = "move";
      evt.dataTransfer.setData("itemID", item.id);
    },
    onDrop(evt, list) {
      console.log("inside on drop" + list);
      const itemID = evt.dataTransfer.getData("itemID");
      const item = this.items.find((item) => item.id == itemID);
      item.list = list;
    },
  },
};
</script>

<style scoped>


.row {
  width: 50%;
  margin:auto;
  display: flex;

}

.inner-row {
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
}

.column1 {
  flex: 45%;
  background-color: bisque;
  /* height: 90vh; */
}
.column2 {
  flex: 45%;
  background-color: rgb(238, 194, 141);
  /* height: 90vh; */
}

.card {
  /* Add shadows to create the "card" effect */
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
  transition: 0.3s;
  width: 25%;
}

.card img {
  width: 35%;
  height: auto;
}

/* On mouse-over, add a deeper shadow */
.card:hover {
  box-shadow: 0 8px 16px 0 rgba(0, 0, 0, 0.2);
}

/* Add some padding inside the card container */
.container {
  padding: 2px 10px;
  margin: 5%;
}

.button {
  margin: 10px;
  border-radius: 3px;
  background-color: #4CAF50; /* Green */
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
}
</style>