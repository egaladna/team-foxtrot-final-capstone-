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
    justify-content: space-between;
}

#item-chooser,
#selected-items {
    display: flex;
    flex-direction: column;
    border: solid #1B3536;
    border-radius: 8px;
    width: fit-content;
    block-size: fit-content;
    padding: 40px;
}




</style>