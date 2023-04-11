<template>
  <div id="main">
      <div id="item-chooser">
           <ItemChooser />
      </div>
     
      <div id="selected-items">
          <SelectedItems />
      </div>
      
  </div>
</template>

<script>
import ItemChooser from '@/components/ItemChooser'
import SelectedItems from '../components/SelectedItems.vue'

export default {
    components: {
        ItemChooser,
        SelectedItems
    }
}
</script>

<style>
#main{
    display: flex;
    justify-content: space-evenly;
}



</style>