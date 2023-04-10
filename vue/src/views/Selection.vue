<template>
  <div>
      <ItemChooser />
      <SelectedItems />
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
div {
    display: flex;
}

</style>