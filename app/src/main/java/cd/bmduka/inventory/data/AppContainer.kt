
package cd.bmduka.inventory.data

import android.content.Context
import cd.bmduka.inventory.data.InventoryDatabase
import cd.bmduka.inventory.data.ItemsRepository
import cd.bmduka.inventory.data.OfflineItemsRepository

interface AppContainer {
    val itemsRepository: ItemsRepository
}

/**
 * [AppContainer] implementation that provides instance of [OfflineItemsRepository]
 */
class AppDataContainer(private val context: Context) : AppContainer {
    /**
     * Implementation for [ItemsRepository]
     */
    override val itemsRepository: ItemsRepository by lazy {
        OfflineItemsRepository(InventoryDatabase.getDatabase(context).itemDao())
    }
}
